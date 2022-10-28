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


        <div class="menuItems">
            <div class="searchBox">
                <form name="search" action="" method="post">
                    <div class="searchBoxInput">
                        <@spring.formInput "searchForm.string" "placeholder='Search...'" "text"/>
                        <button style="margin-top: 10px; margin-left: 510px; background-color: #D84B04; height: 35px; width: 35px;" type="submit" value="Search"><img class="imgS" src="<@spring.url '/css/siteStyle/iconsSearch.png'/>" width="35" height="35"></button>
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
                <li><a href="">Drug name</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitDrugNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitDrugNameDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Client name</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitClientNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitClientNameDsce ">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Use</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitUseExternal">External</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitUseInternal">Internal</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitUseExternalInternal">External-Internal</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitUseMix">Mix</a></li>
                    </ul>
                </li>
                <li><a href="">Release Form</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormTablets">Tablets</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormOintment">Ointment</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormPotion">Potion</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormAqua">Aqua</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormFlour">Flour</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/clientsWait/sortClientWaitFormTincture">Tincture</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
    <br><br><br><br><br>
    <a style="height: 45px;margin-left:1150px" id="addIcon" href="http://localhost:8082/ui/v1/mongoDB/clients/createForm"><img style="" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Component" width="0" height="0"></a>
    <div class="titleComponentDIV">
        <h1 id="titleComponent">Clients is waiting for components table</h1>
    </div>
    <table style="margin-top: -2px" class="table">
        <thead>
        <tr>
            <th>№</th>
            <th style="padding-left: 70px; padding-right: 70px;">Client name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Drug Name</th>
            <th>Components</th>
            <th>Order status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <#list extemporalOrders as order>
        <tbody>
        <tr id="ququ">
            <td></td>
            <td>${order.clientId.clientName}</td>
            <td>${order.clientId.clientPhNum}</td>
            <td>${order.clientId.clientEmail}</td>
            <td>${order.drugId.drugName}</td>
            <td style="text-align: left"><#list order.drugId.componentList as component>
                    <ul style="margin-left: -10px; padding: -5px">
                        <li><a style="font-size: 16px; color: #fedac4; text-decoration: none" href="http://localhost:8082/ui/v1/mongoDB/components/review/${component.id}">${component.componentName}</a></li>
                    </ul>
                </#list>
            </td>
            <td>${order.orderStatus}</td>
            <td  style="background: #196a6a">
                <a style="position:absolute;" href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/editForm/${order.id}"><img id="rot" src="<@spring.url '/css/siteStyle/edit.png'/>" alt="" width="45" height="45"></a>
                <a style="margin-left: 50px;" href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/delete/${order.id}"><img id="rot" src="<@spring.url '/css/siteStyle/delete.png'/>" alt="" width="45" height="45"></a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>


</body>
</html>