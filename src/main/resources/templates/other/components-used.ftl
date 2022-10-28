<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>P&P</title>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/admin.css'/>"/>
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
        <div class="menuItems2">
            <div class="searchBox2">
                <form name="dateRange" action="" method="post">
                    <div class="searchBoxInput2">
                        <form action="UsedComponents">
                            <label style="position: absolute; font-family: Cambria, cursive; color: #0f4040; margin-left: -245px; margin-top: -20px; font-size: 20px">From:</label>
                            <input type="date" name="from" required>
                            <label style="position: absolute; font-family: Cambria, cursive; color: #0f4040; margin-left: -120px; margin-top: -20px; font-size: 20px">To:</label>
                            <input type="date" name="to" required>
                            <button style="margin-top: 20px; margin-left: 530px; background-color: #fedac4; height: 35px; width: 35px;" type="submit" value="dateRange"><img class="imgS"  style="margin-top: 10px" src="<@spring.url '/css/siteStyle/iconsSearchOrange.png'/>" width="40" height="40"></button>
                        </form>
                   </div>
                </form>
            </div>
        </div>
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
            <br>
            <span id="titleSpan" class="nav-text">
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
            <br>
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



    <ul class="dropdown">
        <li><a href="#">Sort By</a>
            <ul>
                <li><a href="">Name</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortNameDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Created at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortCreatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortCreatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Updated at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortUpdatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortUpdatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="#">Measure</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortMeasureKg">kg</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortMeasureL">l</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortMeasureMG">mg</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortMeasureML">ml</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/components/sortMeasureG">g</a></li>
                    </ul>
                </li>
                <li><a href="http://localhost:8082/ui/v1/mongoDB/components/needComponent">Lack</a></li>
                <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/needComponentNow">Needed now</a></li>
                <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/UsedComponents">Used</a></li>
            </ul>
        </li>
    </ul>
    <br><br><br><br><br>
    <a style="height: 45px;margin-left:1150px" id="addIcon" href="http://localhost:8082/ui/v1/mongoDB/components/createForm"><img style="" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="0" height="0"></a>
    <div class="titleComponentDIV">
        <h1 id="titleComponent">Component used table</h1>
    </div>
    <table style="margin-top: -2px" class="table">
        <thead>
        <tr>
            <th>№</th>
            <th style="padding-left: 50px; padding-right: 50px;">Component name</th>
            <th>Measure</th>
            <th>Orders</th>
            <th>Amount|kg/l</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        </thead>
        <#list orders as order>
        <#list order.drugId.componentList as component>
        <tbody>
        <tr id="ququ" class="ququ2">
            <td></td>
            <td><a style="font-size: 16px; color: #fedac4; text-decoration: none" href="http://localhost:8082/ui/v1/mongoDB/components/review/${component.id}">${component.componentName}</a></td>
            <td>${component.measure}</td>
            <td>${component.inStock}</td>
            <td>${component.criticalNorm}</td>
            <td>${component.price} $</td>
            <td  style="background: #196a6a">
                <a style="position:absolute;" href="http://localhost:8082/ui/v1/mongoDB/components/editForm/${component.id}"><img id="rot" src="<@spring.url '/css/siteStyle/edit.png'/>" alt="" width="45" height="45"></a>
                <a style="margin-left: 50px;" href="http://localhost:8082/ui/v1/mongoDB/components/delete/${component.id}"><img id="rot" src="<@spring.url '/css/siteStyle/delete.png'/>" alt="" width="45" height="45"></a>
            </td>
        </tr>
        </#list>
        </#list>
        </tbody>
    </table>
</div>


</body>
</html>