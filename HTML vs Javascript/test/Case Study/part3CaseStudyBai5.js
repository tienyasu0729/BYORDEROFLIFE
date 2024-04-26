function part3CaseStudyBai5() {
    let a = '<h2 style="color: red; text-align: center; font-size: 40px">MENU</h2>\n' +
        '<form style="font-size: 50px" id="bbbb">\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="cafe" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=12000>\n' +
        '    <label for="cafe" >1. Cafe</label><br>\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="camvat" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=20000>\n' +
        '    <label for="camvat" >2. Cam Vắt</label><br>\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="nuocepcarot" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=20000>\n' +
        '    <label for="nuocepcarot" >3. Nước Ép Cà Rốt</label><br>\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="nuocepcachua" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=20000>\n' +
        '    <label for="nuocepcachua" >4. Nước Ép Cà Chua</label><br>\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="nuocloc" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=7000>\n' +
        '    <label for="nuocloc" >5. Nước Lọc</label><br>\n' +
        '    <input style="width: 30px; height: 30px" type="checkbox" id="nuocdua" onclick="checkPriceOfProducPart3CaseStudyBai5(this.value)" value=25000>\n' +
        '    <label for="nuocdua" >6. Nước Dừa</label><br>\n' +
        '    <button style="width: 200px; height: 50px; font-size: 30px; border-color: lawngreen; border-width: 5px" type="button" onclick="printToTheScreenPart3CaseStudyBai5()">Thanh toán </button>\n' +
        '</form>'

    document.write(a);
}
let bill_part3casestudybai5 = 0;
function checkPriceOfProducPart3CaseStudyBai5(check) {
    let amount = +prompt("Nhập vào đây số lượng khách yêu cầu");
    bill_part3casestudybai5 += check * amount;
}

function printToTheScreenPart3CaseStudyBai5() {
    alert("Tổng tiền quý khách cần thanh toán là :" + bill_part3casestudybai5 + " VND");
}
