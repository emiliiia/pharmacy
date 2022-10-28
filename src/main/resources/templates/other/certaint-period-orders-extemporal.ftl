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
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalNameDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Price</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalPriceAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalPriceDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Quantity</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalQuantityAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalQuantityDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Order Go</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalOrderGoAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalOrderGoDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Created at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalCreatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalCreatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="">Updated at</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalUpdatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalUpdatedAtDsce">descending ▼</a></li>
                    </ul>
                </li>
                <li><a href="#">Status</a>
                    <ul>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalStatusInprogress">In Progress</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalStatusGone">Gone</a></li>
                        <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortExtemporalStatusPending">Pending</a></li>
                    </ul>
                </li>
                <li><a href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/sortByOrderGoTerminate">Not gone</a></li>
            </ul>
        </li>
    </ul>
    <br><br><br><br><br>
    <div style="background-color: #D84B04; width: 100px; height: 45px; margin-left: -55px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px; margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/mongoDB/orders/"><p style="margin-top: -5px; margin-left: 00px; color: #fff; font-size: 16px">All</p></a></div>
    <div style="background-color: #D84B04; width: 100px; margin-top: -65px; height: 45px; margin-left: 60px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/mongoDB/orders/officinal/"><p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">Officinal</p></a></div>
    <div style="box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25); background-color: #913300; width: 100px; margin-top: -65px; height: 45px; margin-left: 175px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/"><p style="margin-top: -5px; margin-left: 0px; color: #fff; font-size: 16px">Extemporal</p></a></div>

    <div style="background-color: #D84B04; width: 140px; height: 45px; margin-top: -65px; margin-left: 900px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px; margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/mongoDB/orders/officinal/createForm"><img style="margin-left: -60px; margin-top: 0px" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="45" height="45"><p style="margin-top: -35px; margin-left: 30px; color: #fff; font-size: 16px">Officinal</p></a></div>
    <div style="background-color: #D84B04; width: 140px; margin-top: -65px; height: 45px; margin-left: 1055px; z-index: -1; border-radius: 30px; margin-bottom: 20px;"><a style="height: 45px;margin-left:-30px; margin-top: -5px; text-decoration: none;" class="addIcon" href="http://localhost:8082/ui/v1/mongoDB/orders/extemporal/createForm"><img style="margin-left: -60px; margin-top: 0px" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Request" width="45" height="45"><p style="margin-top: -35px; margin-left: 30px; color: #fff; font-size: 16px">Extemporal</p></a></div>

    <div class="titleComponentDIV">
        <h1 id="titleComponent">Certain period extemporal orders table</h1>
    </div>
    <table style="margin-top: -2px" class="table">
        <thead>
        <tr>
            <th>№</th>
            <th style="padding-left: 50px; padding-right: 50px;">Drug name</th>
            <th>QTY</th>
            <th>Price</th>
            <th>Client</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Date of birth</th>
            <th>Created At</th>
            <th>Updated At</th>
            <th>Actions</th>
        </tr>
        </thead>
        <#list orders as order>
        <tbody>
        <tr id="ququ" class="ququ2">
            <td></td>
            <td><a style="font-size: 16px; color: #fedac4; text-decoration: none" href="http://localhost:8082/ui/v1/mongoDB/extemporal/drugs/review/${order.drugId.id}">${order.drugId.drugName}</a></td>
            <td>${order.drugQuantity}</td>
            <td>${order.price} $</td>
            <td><a style="font-size: 16px; color: #fedac4; text-decoration: none" href="http://localhost:8082/ui/v1/mongoDB/clients/review/${order.clientId.id}">${order.clientId.clientName}</a></td>
            <td>${order.clientId.clientPhNum}</td>
            <td>${order.clientId.clientEmail}</td>
            <td>${order.clientId.clientDateBirth}</td>
            <td>${order.createdAt}</td>
            <td>${order.updatedAt}</td>
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