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
            <p></p><br>
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
        <ul><br>
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
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortNameDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Price</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortPriceAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortPriceDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Quantity</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortQuantityAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortQuantityDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Order Go</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortOrderGoAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortOrderGoDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Created at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortCreatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortCreatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Updated at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortUpdatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortUpdatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="#">Status</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortStatusInprogress">In Progress</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortStatusGone">Gone</a></li>
                        <li><a href="http://localhost:8082/ui/v1/postgreeSQL/orders/sortStatusPending">Pending</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
    <br><br><br><br><br>
    <div style="box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25); background-color: #913300; width: 100px; height: 45px; margin-left: -55px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px; margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/postgreeSQL/orders/"><p style="margin-top: -5px; margin-left: 00px; color: #fff; font-size: 16px">All</p></a></div>
    <div style="background-color: #D84B04; width: 100px; margin-top: -65px; height: 45px; margin-left: 60px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/postgreeSQL/orders/officinal/"><p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">Officinal</p></a></div>
    <div style="background-color: #D84B04; width: 100px; margin-top: -65px; height: 45px; margin-left: 175px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/postgreeSQL/orders/extemporal/"><p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">Extemporal</p></a></div>

    <form action="CertainPeriod">
        <div style="box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25); background-color: #fedac4; padding-left: 10px; padding-right: 10px; width: 140px; margin-top: -65px; height: 45px; margin-left: 400px; z-index: -1; border-radius: 30px; margin-bottom: 20px;">
            <a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon">
                <p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">
                    <input style="background-color: rgba(255,247,247,0); margin-top: -5px; font-size: 14px" type="date" name="from" required>
                </p>
            </a>
        </div>
        <div style="box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25); background-color: #fedac4; padding-left: 10px;  padding-right: 10px; width: 140px; margin-top: -65px; height: 45px; margin-left: 570px; z-index: -1; border-radius: 30px; margin-bottom: 20px;">
            <a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon">
                <p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">
                    <input style="background-color: rgba(255,247,247,0); margin-top: -5px; font-size: 14px" type="date" name="to" required>
                </p>
            </a>
        </div>
        <div style="background-color: #fedac4; width: 50px; margin-top: -65px; height: 45px; margin-left: 740px; z-index: -1; border-radius: 30px; margin-bottom: 20px;">

            <button  style="background: rgba(255,247,247,0); cursor: pointer" value="dateRange">
                <img style="background: rgba(255,247,247,0); margin-top: 5px" src="<@spring.url '/css/siteStyle/iconsSearchOrange.png'/>" width="30" height="30">
            </button>
        </div>
    </form>

    <div style="background-color: #D84B04; width: 140px; height: 45px; margin-top: -65px; margin-left: 900px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px; margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/postgreeSQL/orders/officinal/createForm"><img style="margin-left: -60px; margin-top: 0px" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="45" height="45"><p style="margin-top: -35px; margin-left: 30px; color: #fff; font-size: 16px">Officinal</p></a></div>
    <div style="background-color: #D84B04; width: 140px; margin-top: -65px; height: 45px; margin-left: 1055px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/postgreeSQL/orders/extemporal/createForm"><img style="margin-left: -60px; margin-top: 0px" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="45" height="45"><p style="margin-top: -35px; margin-left: 30px; color: #fff; font-size: 16px">Extemporal</p></a></div>
    <div class="titleComponentDIV">
        <h1 id="titleComponent">Orders table</h1>
    </div>
    <table style="margin-top: -2px" class="table">
        <thead>
        <tr>
            <th>№</th>
            <th style="padding-left: 50px; padding-right: 50px;">Drug name</th>
            <th>QTY</th>
            <th>Client</th>
            <th style="padding-left: 50px; padding-right: 50px;">Dr. name</th>
            <th>Diagnos</th>
            <th>Order status</th>
            <th>Price</th>
            <th>Order ready</th>
            <th>Created At</th>
            <th>Updated At</th>
            <th>Actions</th>
        </tr>
        </thead>
        <#list orders as order>
        <tbody>
        <tr id="ququ" class="ququ2">
            <td></td>
            <td>${order.drugId.drugName}</td>
            <td>${order.drugQuantity}</td>
            <td><a style="font-size: 16px; color: #fedac4; text-decoration: none" href="http://localhost:8082/ui/v1/postgreeSQL/clients/review/${order.clientId.id}">${order.clientId.clientName}</a></td>
            <td>${order.docName}</td>
            <td>${order.diagnos}</td>
            <td>${order.orderStatus}</td>
            <td>${order.price} $</td>
            <td>${order.orderGo}</td>
            <td>${order.createdAt}</td>
            <td>${order.updatedAt}</td>
            <td  style="background: #196a6a">
                <a style="margin-left: 0px;" href="http://localhost:8082/ui/v1/postgreeSQL/orders/delete/${order.id}"><img id="rot" src="<@spring.url '/css/siteStyle/delete.png'/>" alt="" width="45" height="45"></a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>


</body>
</html>