<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>P&P</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/adminHome.css'/>"/>
    <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
    <link rel="icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
</head>
<body>
<div class="header">

    <div class="header_2">
        <img id="logo" src="<@spring.url '/css/siteStyle/logo.png'/>" alt="Pills and Potions" width="100" height="100">

        <a href="http://localhost:8082/home" class="logoText">
            <p> <b id="pANDp">P&P</b><br>
                <b id="pillsAndPotions">PILLS AND POTIONS</b></p>
        </a>


        <div class="coshAccountPosition2">
            <a href="http://localhost:8082/ui/v1/adminPage/"><img style="margin-top: -3px" id="coshAccountHover" src="<@spring.url '/css/siteStyle/iconHome.png'/>" width="55" height="55"></a>
        </div>

        <div class="coshAccountPosition">
            <a href="/logout"><img id="coshAccountHover" src="<@spring.url '/css/siteStyle/iconLogOut.png'/>" width="50" height="50"></a>
        </div>
    </div>
</div>


<div class="mainGroundwork">
    <nav class="main-menu">
        <ul>
            <p></p>
            <span id="titleSpan2" class="nav-text">
                Mongo DB
                </span>

            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/clients/">
                    <i class="fa fa-laptop fa-2x"><img src="<@spring.url '/css/siteStyle/iconsClient.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Clients table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/drugs/">
                    <i class="fa fa-list fa-2x"><img src="<@spring.url '/css/siteStyle/iconsDrug.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Drugs table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/orders/">
                    <i class="fa fa-folder-open fa-2x"><img src="<@spring.url '/css/siteStyle/iconCoshik.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Orders table
                        </span>
                </a>

            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/">
                    <i class="fa fa-info fa-2x"><img src="<@spring.url '/css/siteStyle/iconBrand.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Manufacturers table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/technologyBook/">
                    <i class="fa fa-bar-chart-o fa-2x"><img src="<@spring.url '/css/siteStyle/iconBook.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Technology Book
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/components/">
                    <i class="fa fa-font fa-2x"><img src="<@spring.url '/css/siteStyle/iconComponent.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Components table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/mongoDB/requestComponents/">
                    <i class="fa fa-table fa-2x"><img src="<@spring.url '/css/siteStyle/iconRequest.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Requests for components
                        </span>
                </a>
            </li>
        </ul>
    </nav>

    <nav class="main-menu2">
        <ul>
            <span id="titleSpan" class="nav-text">
                    Postgree SQL
                    </span>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/clients/">
                    <i class="fa fa-laptop fa-2x"><img src="<@spring.url '/css/siteStyle/iconsClient.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Clients table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/drugs/">
                    <i class="fa fa-list fa-2x"><img src="<@spring.url '/css/siteStyle/iconsDrug.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Drugs table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/orders/">
                    <i class="fa fa-folder-open fa-2x"><img src="<@spring.url '/css/siteStyle/iconCoshik.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Orders table
                        </span>
                </a>

            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/manufacturers/">
                    <i class="fa fa-info fa-2x"><img src="<@spring.url '/css/siteStyle/iconBrand.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Manufacturers table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/technologyBook/">
                    <i class="fa fa-bar-chart-o fa-2x"><img src="<@spring.url '/css/siteStyle/iconBook.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Technology Book
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/components/">
                    <i class="fa fa-font fa-2x"><img src="<@spring.url '/css/siteStyle/iconComponent.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Components table
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/requestComponents/">
                    <i class="fa fa-table fa-2x"><img src="<@spring.url '/css/siteStyle/iconRequest.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Requests for components
                        </span>
                </a>
            </li>
            <br><br>
            <span id="titleSpan" class="nav-text">
                    Management
                    </span>
            <br>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/key/">
                    <i class="fa fa-table fa-2x"><img src="<@spring.url '/css/siteStyle/iconKeys.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Keys
                        </span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8082/ui/v1/postgreeSQL/role/">
                    <i class="fa fa-table fa-2x"><img src="<@spring.url '/css/siteStyle/iconRoles.png'/>" alt="" width="50" height="50"></i>
                    <span class="nav-text">
                        Roles
                        </span>
                </a>
            </li>
        </ul>
    </nav>
    <br><br><br><br><br>
    <div class="titleComponentDIV">
        <h1 id="titleComponent">Main page</h1>
    </div>
    <div style="background-color: #D84B04; width: 140px; margin-top: -75px; height: 45px; margin-left: 1055px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/adminPage/loadingScript"><img style="margin-left: -60px; margin-top: 0px" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="45" height="45"><p style="margin-top: -35px; margin-left: 30px; color: #fff; font-size: 16px">By script</p></a></div>
    <br><br>
    <#list forms as form>
    <div class="freeDoctor" style="margin-top: -10px">
        <p style="margin-top: 50px; float: left; font-size: 65px; color: #fedac4;">Wellcome, ${form.username}!</p>
    </div>

    <hr class="hrFirst">
    <div style="margin: auto">
        <h1 id="titleComponent">Mongo</h1>
    </div>

    <br><br><br><br>
    <div class="offerItems">
        <nav>
            <ul class="navOfferItems">
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconsClient.png'/>" alt="">
                    <div class="info">
                        <p>Clients</p>
                        <span>${form.mongoClient}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconsDrug.png'/>" alt="">
                    <div class="info">
                        <p>Drugs</p>
                        <span>${form.mongoDrug}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconCoshik.png'/>" alt="">
                    <div class="info">
                        <p>Orders</p>
                        <span>${form.mongoOrder}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconRequest.png'/>" alt="">
                    <div class="info">
                        <p>Requests</p>
                        <span>${form.mongoRequest}</span>
                    </div>
                </li>

            </ul>
        </nav>
    </div>
    <br><br>
    <div style="margin: auto">
        <h1 id="titleComponent">PostgreSQL</h1>
    </div>
    <br><br><br><br>
    <div class="offerItems">
        <nav>
            <ul class="navOfferItems">
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconsClient.png'/>" alt="">
                    <div class="info">
                        <p>Clients</p>
                        <span>${form.sqlClient}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconsDrug.png'/>" alt="">
                    <div class="info">
                        <p>Drugs</p>
                        <span>${form.sqlDrug}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconCoshik.png'/>" alt="">
                    <div class="info">
                        <p>Orders</p>
                        <span>${form.sqlOrder}</span>
                    </div>
                </li>
                <li>
                    <img src="<@spring.url '/css/siteStyle/iconRequest.png'/>" alt="">
                    <div class="info">
                        <p>Requests</p>
                        <span>${form.sqlRequest}</span>
                    </div>
                </li>

            </ul>
        </nav>
    </div>
    </#list>
</div>


</body>
</html>

