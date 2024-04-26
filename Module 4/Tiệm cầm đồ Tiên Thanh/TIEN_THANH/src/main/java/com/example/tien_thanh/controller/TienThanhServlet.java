package com.example.tien_thanh.controller;

import com.example.tien_thanh.Service.IAndroid_PhoneService;
import com.example.tien_thanh.Service.Impl.Android_PhoneServiceImpl;
import com.example.tien_thanh.model.Android_Phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "TienThanhServlet", value = "/tienthanh")
public class TienThanhServlet extends HttpServlet {
    private IAndroid_PhoneService android_phoneService;

    public void init() {
        android_phoneService = new Android_PhoneServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        listAndroid_Phone(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String action2 = request.getParameter("action2");
        if (action == null) {
            action = "";
        }
        System.out.println();
        if (action2 == null) {
            action2 = "";
        }
        switch (action2) {
            case "check_if_id_exist":
                check_if_id_exist(request,response);
                break;
            case "save_create_android_phone":
                create_Android_Phone(request,response);
                break;
            case "delete_android_phone_by_id":
                delete_android_phone_by_id(request,response);
                break;
            case "save_edit_android_phone":
                edit_android_phone(request,response);
                break;
            case "interestPayment":
                interest_payment(request,response);
                break;
            case "take_the_product_out":
                take_the_product(request,response);
                break;
            case "extend_interest_payment":
                extend_interest_payment(request,response);
                break;
            case "list_find_android_phone_similar_by_id":
                list_find_android_phone_similar_by_id(request,response);
                break;
            case "list_find_android_phone_similar_by_name":
                list_find_android_phone_similar_by_name(request,response);
                break;
            case "watch_late_list_android_phone":
                watch_late_list_android_phone(request,response);
                break;
            case "watch_near_term_list_android_phone":
                watch_near_term_list_android_phone(request,response);
                break;    
        }
        switch (action) {
            case "create":
                Form_create_Android_Phone(request, response);
                break;
            case "list_Android_phone":
            case "reload":
                listAndroid_Phone(request,response);
                break;
            case "edit_Android_phone":
                Form_edit_android_phone(request,response);
                break;
        }
    }

    private void check_if_id_exist(HttpServletRequest request, HttpServletResponse response) {
        boolean check = android_phoneService.check_if_id_exist(request.getParameter("id_need_to_check"));
        try {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.valueOf(check));
        } catch (IOException e) {

        }
    }

    private void watch_near_term_list_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.near_term_list_android_phone();
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);

    }

    private void watch_late_list_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.late_list_android_phone();
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);

    }

    private void list_find_android_phone_similar_by_name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String find_by_name = request.getParameter("find_by_name");
        List<Android_Phone> androidPhones = android_phoneService.list_Find_Android_Phone_Similar_By_Name(find_by_name);
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);

    }

    private void list_find_android_phone_similar_by_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String find_by_id = request.getParameter("find_by_id");
        List<Android_Phone> androidPhones = android_phoneService.list_Find_Android_Phone_Similar_By_Id(find_by_id);
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }

    private void extend_interest_payment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String start_date = request.getParameter("start_date_interest_payment");
        int days = Integer.parseInt(request.getParameter("days_interest_payment"));
        String id = request.getParameter("id_extend_interest_payment");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            Date startDate = dateFormat.parse(start_date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, days);
            Date newDate = calendar.getTime();
            android_phoneService.interest_payment(id, newDate); // sửa ngày sau khi gia hạn trong mySQL
            String result = "- Gia hạn thành công";
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);

        } catch (Exception e) {
            String result = "- Gia hạn Không thành công";
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
        }

    }

    private void take_the_product(HttpServletRequest request, HttpServletResponse response) {
        String start_date = request.getParameter("start_date_interest_payment");
        int price = Integer.parseInt(request.getParameter("price_interest_payment"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            Date startDate = dateFormat.parse(start_date);
            long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
            String result = "- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + daysBetween + " ngày là : " + money_all_days((int) daysBetween,price);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
//            String jsCode = "alert(\"" + result + "\");";
//            response.getWriter().write("<script type='text/javascript'>" + jsCode + "</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void interest_payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String start_date = request.getParameter("start_date_interest_payment");
//        System.out.println(start_date);
////        int price = Integer.parseInt(request.getParameter("price_interest_payment"));
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
////        int interest_payment = 0;
//        try {
//            LocalDate startDate = LocalDate.parse(start_date, dateFormat);
//            long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
//            String result = "Khoảng cách giữa hai ngày là " + daysBetween + " ngày.";
//            response.setContentType("text/plain");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String start_date = request.getParameter("start_date_interest_payment");
        int price = Integer.parseInt(request.getParameter("price_interest_payment"));
        int days = Integer.parseInt(request.getParameter("days_interest_payment"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            Date startDate = dateFormat.parse(start_date);
            long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

            //            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(startDate);
//            calendar.add(Calendar.DATE, 10);
//            Date newDate = calendar.getTime();

//            android_phoneService.interest_payment(id, newDate); // sửa ngày sau khi gia hạn trong mySQL

            String result = "- Khoảng cách giữa hai ngày là " + daysBetween + " ngày." + "\n- Số tiền lãi " + days + " ngày là : " + money_all_days(days,price);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void edit_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name_owner = request.getParameter("name_owner");
        String name_phone = request.getParameter("name_phone");

        // ở JSP gửi về kiểu string và định dạng là  ###,###,###,### nên phải xoá dấu , mới có thể có một số
        String numericValue = request.getParameter("price").replace(",", "");
        int price = Integer.parseInt(numericValue);

        String status = request.getParameter("status");
        String password = request.getParameter("password");
        String note = request.getParameter("note");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_Date = null;
        try {
            start_Date = dateFormat.parse(request.getParameter("start_Date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String id_of_phone = request.getParameter("id_of_phone");
        String phone_number_owner = request.getParameter("phone_number_owner");
        Android_Phone android_phone = new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note);
        android_phoneService.edit_Android_Phone(android_phone);
//        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request,response);
    }

    private void Form_edit_android_phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_android_phone_edit = request.getParameter("id_need_to_edit");
        request.setAttribute("id_need_to_edit",id_android_phone_edit);
        request.getRequestDispatcher("Android_Phone/edit_Android_Phone.jsp").forward(request,response);
    }

    private void delete_android_phone_by_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_need_to_delete = request.getParameter("id_need_to_delete");
        String action_stored_procedure = request.getParameter("action_stored_procedure");
        if (action_stored_procedure.equals("take_the_product")){
            android_phoneService.delete_Android_Phone(id_need_to_delete);
            android_phoneService.stored_procedure(action_stored_procedure);
        }else {
            android_phoneService.delete_Android_Phone(id_need_to_delete);
        }
        String result = "- Xoá thành công";
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }

    private void listAndroid_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Android_Phone> androidPhones = android_phoneService.displayAndroid_Phone();
//        System.out.println(androidPhones.get(1).getStart_Date().getMonth());
        request.setAttribute("listAndroid_Phone", androidPhones);
        request.getRequestDispatcher("Android_Phone/listAndroid_Phone.jsp").forward(request, response);
    }
    private void Form_create_Android_Phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Android_Phone/createAndroid_Phone.jsp").forward(request, response);
    }
    private void create_Android_Phone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name_owner = request.getParameter("name_owner");
        String name_phone = request.getParameter("name_phone");

        // ở JSP gửi về kiểu string và định dạng là  ###,###,###,### nên phải xoá dấu , mới có thể có một số
        String numericValue = request.getParameter("price").replace(",", "");
        int price = Integer.parseInt(numericValue);

        String status = request.getParameter("status");
        String password = request.getParameter("password");
        String note = request.getParameter("note");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_Date = null;
        try {
            start_Date = dateFormat.parse(request.getParameter("start_Date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String id_of_phone = request.getParameter("id_of_phone");
        String phone_number_owner = request.getParameter("phone_number_owner");

        if (status.equals("")){
            status = "Bình thường";
        }
        if (note.equals("")){
            note = "Không có";
        }
        if (password.equals("")){
            password = "Không có";
        }
        if (phone_number_owner.equals("")){
            phone_number_owner = "Không có";
        }


//        BufferedReader reader = request.getReader();
//        StringBuilder stringBuilder = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        String jsonString = stringBuilder.toString();
//        JSONObject jsonObject = new JSONObject(jsonString);

//        String id = jsonObject.getString("id");
//        String name_owner = jsonObject.getString("name_owner");
//        String name_phone = jsonObject.getString("name_phone");
//        int price = (int) jsonObject.getDouble("price");
//        String status = jsonObject.getString("status");
//        String password = jsonObject.getString("password");
//        String note = jsonObject.getString("note");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date start_Date = null;
//        try {
//            start_Date = dateFormat.parse(jsonObject.getString("start_Date"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

        Android_Phone android_phone = new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note);
        android_phoneService.add_New_Android_Phone(android_phone);
//        request.getRequestDispatcher("Android_Phone/createAndroid_Phone.jsp").forward(request,response);
    }
    private int money_all_days(int days, int price){
        int payment = 0;
        payment = ((price / 1000000) * 3000 + less_than_500(price)) * days;
        return payment;
    }
    private int less_than_500 (int price){
        int support = price % 1000000;
        if ( support == 0){
            return 0;
        }else if (support < 500000){
            return 2000;
        }else {
            return 3000;
        }
    }
}
