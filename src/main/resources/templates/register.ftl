<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/admin.css'/>"/>
    <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
    <link rel="icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
</head>
<body>

<div class="mainGroundwork">
    <div  style="height: 550px; margin-top: 60px" class="AddContainer">
        <div class="brand-logoAccount"></div>
        <div class="brand-title">Registration</div>
        <form name="key" action="" method="post">
            <div class="inputs">
                <label>LOGIN</label>
                <@spring.formInput "form.username" "required" />
                <label>PASSWORD</label>
                <@spring.formPasswordInput "form.password" "required" />
                <label>CONFIRM PASSWORD</label>
                <@spring.formPasswordInput "form.confirmPassword" "required" />
                <form action="">
                    <button type="submit">SUBMIT</button>
                </form>
            </div>
        </form>
    </div>
</div>


</body>
</html>