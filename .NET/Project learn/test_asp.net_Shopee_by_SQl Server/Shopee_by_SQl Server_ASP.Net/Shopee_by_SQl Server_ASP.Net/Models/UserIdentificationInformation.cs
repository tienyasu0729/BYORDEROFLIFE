using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserIdentificationInformation
{
    public int IdUser { get; set; }

    public string? Cccd { get; set; }

    public string? ImageSelfie { get; set; }

    public string? ImageCccdFront { get; set; }

    public string? ImageCccdBack { get; set; }

    public virtual User IdUserNavigation { get; set; } = null!;
}
