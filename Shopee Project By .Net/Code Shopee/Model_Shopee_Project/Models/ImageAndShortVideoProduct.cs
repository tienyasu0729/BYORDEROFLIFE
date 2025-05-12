using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ImageAndShortVideoProduct
{
    public int IdProduct { get; set; }

    public string? Video { get; set; }

    public string FolderImage { get; set; } = null!;

    public virtual Product IdProductNavigation { get; set; } = null!;
}
