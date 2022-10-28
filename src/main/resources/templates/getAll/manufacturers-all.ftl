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
        <li><a href="">Name</a>
          <ul>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortNameAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortNameDsce">descending ▼</a></li>
          </ul>
        </li>
        <li><a href="">Created at</a>
          <ul>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortCreatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortCreatedAtDsce">descending ▼</a></li>
          </ul>
        </li>
        <li><a href="">Updated at</a>
          <ul>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortUpdatedAtAsce">ascending&nbsp;&nbsp;&nbsp;▲</a></li>
            <li><a href="http://localhost:8082/ui/v1/mongoDB/manufacturers/sortUpdatedAtDsce">descending ▼</a></li>
          </ul>
        </li>
      </ul>
    </li>
  </ul>
  <br><br><br><br><br>
  <a style="height: 45px;margin-left:1150px" id="addIcon" href="http://localhost:8082/ui/v1/mongoDB/manufacturers/createForm"><img style="" id="rot" src="<@spring.url '/css/siteStyle/iconAdd.png'/>" alt="Add Component" width="45" height="45"></a>
  <div class="titleComponentDIV">
    <h1 id="titleComponent">Manufacturers table</h1>
  </div>
  <table style="margin-top: -2px" class="table">
    <thead>
    <tr>
      <th>№</th>
      <th style="padding-left: 50px; padding-right: 50px;">Manufacturer Name</th>
      <th>Agent Name</th>
      <th>Phone</th>
      <th>Country</th>
      <th>Created At</th>
      <th>Updated At</th>
      <th>Actions</th>
    </tr>
    </thead>
    <#list manufacturers as manufacturer>
    <tbody>
    <tr id="ququ">
      <td></td>
      <td>${manufacturer.manufacturerName}</td>
      <td>${manufacturer.agentName}</td>
      <td>${manufacturer.agentPhNum}</td>
      <td>${manufacturer.country}</td>
      <td>${manufacturer.createdAt}</td>
      <td>${manufacturer.updatedAt}</td>
      <td  style="background: #196a6a">
        <a style="position:absolute;" href="http://localhost:8082/ui/v1/mongoDB/manufacturers/editForm/${manufacturer.id}"><img id="rot" src="<@spring.url '/css/siteStyle/edit.png'/>" alt="" width="45" height="45"></a>
        <a style="margin-left: 50px;" href="http://localhost:8082/ui/v1/mongoDB/manufacturers/delete/${manufacturer.id}"><img id="rot" src="<@spring.url '/css/siteStyle/delete.png'/>" alt="" width="45" height="45"></a>
      </td>
    </tr>
    </#list>
    </tbody>
  </table>
</div>


</body>
</html>