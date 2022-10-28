<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Forgot password</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/admin.css'/>"/>
    <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
    <link rel="icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
</head>
<body>

<div class="mainGroundwork">
    <div  style="height: 450px; margin-top: 60px" class="AddContainer">
        <div class="brand-logoAccount"></div>
        <div class="brand-title">Forgot password</div>
            <div class="inputs">
                <form name="search" action="" method="post">
                        <@spring.formInput "searchForm.string" "placeholder='Search...'" "text"/>
                        <button style="margin-top: -60px; margin-left: 370px; background-color: #2F7474; height: 50px; width: 50px;" type="submit" value="Search"><img class="imgS" src="<@spring.url '/css/siteStyle/iconsSearch.png'/>" width="35" height="35"></button>
                </form>
                <label>Result:</label>
                <#list keys as key>
                    <button style="background: #ecf0f3; padding: 10px;	padding-left: 20px;	height: 50px;font-size: 18px;border-radius: 50px;box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white; color: #0f4040">${key.password}</button>
                </#list>
                <form action="/login">
                    <button style="height: 30px; background-color: transparent; box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);" type="submit">Log in</button>
                </form>
                <form style="margin-top: -20px; margin-bottom: -20px" action="">
                    <button style="height: 5px; background-color: transparent; box-shadow: 0px 0px 0px rgba(0, 0, 0, 0); cursor: none" type="submit">or</button>
                </form>
                <form action="/registration">
                    <button style="height: 30px; background-color: transparent; box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);" type="submit"><br>Create an account</button>
                </form>
            </div>
    </div>
</div>


</body>
</html>