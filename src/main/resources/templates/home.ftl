<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>P&P</title>
  <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>"/>
  <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
  <link rel="icon" type="image/vnd.microsoft.icon" href="<@spring.url '/css/siteStyle/logoIcon.ico'/>"/>
</head>
<body>
<div class="header">
  <div class="header_1">

        <span id="contactSpan">
          <span id="iconPhone">
            <img src="<@spring.url '/css/siteStyle/iconPhone.png'/>" alt="" width="34" height="32">
          </span>
          <p id="phNum"> + 380 99 77 88 555<br>
            Daily from 7:55 to 20:05</p>
        </span>

    <a href="https://mail.google.com/mail/u/0/#inbox?compose=GTvVlcSKjgLDGjBBkmLwVBfHjpjJQXtwrqjXWlFlGVFcvlpfTQrQPNSHFFzrPpnFpbTVMhNsnVmQf" id="askUs">ASK US ANYTHING. EMAIL US</a>

    <a href="#"><button class="button-12" id="registButton" role="button"><b id="b">Regi</b>&nbsp;ster</button></a>
    <a href="#"><button  class="button-12" id="logInButton" role="button"><b id="b">Log</b> In&nbsp;&nbsp;&nbsp;</button></a>
  </div>


  <div class="header_2">
    <img id="logo" src="<@spring.url '/css/siteStyle/logo.png'/>" alt="Pills and Potions" width="100" height="100">

    <a href="#" class="logoText">
      <p> <b id="pANDp">P&P</b><br>
        <b id="pillsAndPotions">PILLS AND POTIONS</b></p>
    </a>

    <div class="menuItems">
      <div class="searchBox">
        <form action="">
          <input class="searchInput" type="text" autocomplete="off" placeholder="Search..." name="search">
          <button id="searchButton" type="submit"><img src="<@spring.url '/css/siteStyle/iconsSearch.png'/>" width="35" height="35"></button>
        </form>
      </div>
    </div>

    <div class="coshAccountPosition">
      <a href="#"><img id="coshAccountHover" src="<@spring.url '/css/siteStyle/iconCoshik.png'/>" width="70" height="70"></a>
      <a href="#"><img id="coshAccountHover" src="<@spring.url '/css/siteStyle/iconAccount.png'/>" width="70" height="70"></a>
    </div>

  </div>
</div>

<div class="mainGroundwork">

  <div class="slider">
    <div class="slides">

      <input type="radio" name="radio-btn" id="radio1">
      <input type="radio" name="radio-btn" id="radio2">
      <input type="radio" name="radio-btn" id="radio3">
      <input type="radio" name="radio-btn" id="radio4">

      <div class="slide slide1 first">
        <img src="<@spring.url '/css/siteStyle/pills_1.png'/>" alt="">
        <a href="#"><button id="learnMoreButton" role="button">Learn more</button></a>
      </div>

      <div class="slide">
        <img src="<@spring.url '/css/adv/adv_1.png'/>" alt="">
      </div>

      <div class="slide">
        <img src="<@spring.url '/css/adv/adv_2.png'/>" alt="">
      </div>

      <div class="slide">
        <img src="<@spring.url '/css/adv/adv_3.png'/>" alt="">
      </div>

      <div class="navigation-auto">
        <div class="auto-btn1"></div>
        <div class="auto-btn2"></div>
        <div class="auto-btn3"></div>
        <div class="auto-btn4"></div>
      </div>

      <div class="navigation-manual">
        <label for="radio1" class="manual-btn"></label>
        <label for="radio2" class="manual-btn"></label>
        <label for="radio3" class="manual-btn"></label>
        <label for="radio4" class="manual-btn"></label>
      </div>
    </div>

    <script type="text/javascript">
      var counter = 1;
      setInterval(function(){
        document.getElementById('radio' + counter).checked = true;
        counter++;
        if(counter > 4){
          counter = 1;
        }
      }, 5000);
    </script>
  </div>

  <div id="pillsSecond">
    <p id="readyMade">Ready-made product</p>
    <nav>
      <ul>
        <li class="dropdown"><a href = "#"><img src="<@spring.url '/css/siteStyle/iconTablets.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Tablets</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTablets">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTablets">PostgreSQL</a></li>
          </ul>
        </li>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconOin.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Ointments</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormOintment">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTablets">PostgreSQL</a></li>
          </ul>
        </li>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconAqua.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Tinctures</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
          </ul>
        </li>
      </ul>
    </nav>

    <p id="readyMade">Pharmacy-made product</p>
    <nav>
      <ul>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconPotions.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Potions</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
          </ul>
        </li>
        <li class="dropdown"><a href = "#"><img src="<@spring.url '/css/siteStyle/iconAqua.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Aqua</a>
          <ul>
            <ul>
              <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
              <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
            </ul>
          </ul>
        </li>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconOin.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Ointments</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
          </ul>
        </li>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconAqua.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Tinctures</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
          </ul>
        </li>
        <li><a href = "#"><img src="<@spring.url '/css/siteStyle/iconPowder.png'/>" alt="" width="40px" height="">&nbsp;&nbsp;Powder</a>
          <ul>
            <li><a href = "http://localhost:8082/ui/v1/mongoDB/officinal/drugs/sortOfficinalFormTincture">MongoDB</a></li>
            <li><a href = "http://localhost:8082/ui/v1/postgreeSQL/officinal/drugs/sortOfficinalFormTincture">PostgreSQL</a></li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>

  <div class="advCircle">
    <p id="advCircleText">up to <br>
      <b id="fiftyPer">50%</b> <br>
      discount </p>
  </div>

</div>

<hr class="hrFirst">

<div class="offerItems">
  <nav>
    <ul class="navOfferItems">
      <li>
        <img src="<@spring.url '/css/siteStyle/deliveryIcon.svg'/>" alt="">
        <div class="info">
          <p>Free delivery</p>
          <span>On all orders</span>
        </div>
      </li>
      <li>
        <img src="<@spring.url '/css/siteStyle/moneyIcon.png'/>" alt="">
        <div class="info">
          <p>10 Days returns</p>
          <span>Moneyback
                      guarantee</span>
        </div>
      </li>
      <li>
        <img src="<@spring.url '/css/siteStyle/giftIcon.png'/>" alt="">
        <div class="info">
          <p>Offer & Gifts</p>
          <span>On all orders</span>
        </div>
      </li>
      <li>
        <img src="<@spring.url '/css/siteStyle/paymentIcon.png'/>" alt="">
        <div class="info">
          <p>Secure paymens</p>
          <span>Protected by
                      paypal</span>
        </div>
      </li>

    </ul>
  </nav>
</div>

<hr class="hrFirst">

<div class="secondGroundWork">
  <div class="tittleSection">
    <img src="<@spring.url '/css/siteStyle/iconFire.png'/>" alt="" width="50px">
    <p class="titlesOfSections">Bestsellers</p>
  </div>

  <div>
    <nav>
      <ul class="navProductItems">
        <li>
          <div class="product-card">
            <div class="logo-cart">
            </div>
            <div class="main-images">
              <img id="first" class="first active" src="<@spring.url '/css/product/pr_1.png'/>" alt="">
            </div>
            <div class="shoe-details">
              <span class="shoe_name">Ashwagandha Root Capsules</span>
            </div>
            <div class="color-price">
              <div class="price">
                <span class="price_num">$15.50</span>
              </div>
            </div>
            <div class="button">
              <div class="button-layer"></div>
              <form action="">
                <button>Add To Cart</button>
              </form>
            </div>
          </div>
        </li>
        <li>
          <div class="product-card">
            <div class="logo-cart">
            </div>
            <div class="main-images">
              <img id="first" class="first active" src="<@spring.url '/css/product/pr_2.png'/>" alt="">
            </div>
            <div class="shoe-details">
                    <span class="shoe_name">Tummy Soother Pastilles
                    </span>
            </div>
            <div class="color-price">
              <div class="price">
                <span class="price_num">$4.25</span>
              </div>
            </div>
            <div class="button">
              <div class="button-layer"></div>
              <form action="">
                <button>Add To Cart</button>
              </form>
            </div>
          </div>
        </li>
        <li>
          <div class="product-card">
            <div class="logo-cart">
            </div>
            <div class="main-images">
              <img id="first" class="first active" src="<@spring.url '/css/product/pr_3.png'/>" alt="">
            </div>
            <div class="shoe-details">
              <span class="shoe_name">Alfalfa Extract</span>
            </div>
            <div class="color-price">
              <div class="price">
                <span class="price_num">$11.25</span>
              </div>
            </div>
            <div class="button">
              <div class="button-layer"></div>
              <form action="">
                <button>Add To Cart</button>
              </form>
            </div>
          </div>
        </li>
        <li>
          <div class="product-card">
            <div class="logo-cart">
            </div>
            <div class="main-images">
              <img id="first" class="first active" src="<@spring.url '/css/product/pr_4.png'/>" alt="">
            </div>
            <div class="shoe-details">
                    <span class="shoe_name">Adrenal Health Capsules
                    </span>
            </div>
            <div class="color-price">
              <div class="price">
                <span class="price_num">$29.00</span>
              </div>
            </div>
            <div class="button">
              <div class="button-layer"></div>
              <form action="">
                <button>Add To Cart</button>
              </form>
            </div>
          </div>
        </li>
      </ul>
    </nav>
  </div>
</div>
<hr class="hrFirst">

<div class="freeDoctor">
  <img id="doctor" src="<@spring.url '/css/siteStyle/doctorPhoto.png'/>" alt="">
  <h2 id="freeDoctorH2">Free chat with an experienced pharmacist</h2>
  <p id="freeDoctorP">Describe the symptoms or the right drug - we will help you choose its dosage or analogue,
    place an order with home delivery or just consult. We are 28 pharmacists and 0 bots.
    So we will always be in touch with you and be able to communicate at any time.</p>

  <div class="teleVibSpan">
    <div id="telegramDiv">
      <a href="#">
        <img src="<@spring.url '/css/siteStyle/iconTelegram.png'/>" alt="">
        <p  id="telegramP">Telegram</p>
      </a>
    </div>
    <div id="viberDiv">
      <a href="#">
        <img src="<@spring.url '/css/siteStyle/iconViber.png'/>" alt="">
        <p id="viberP">Viber</p>
      </a>
    </div>
    <p id="freeDoctorTime">
      Online: 08:00 - 21:00,<br>
      without weekends
    </p>

  </div>
</div>

<hr class="hrFirst">

<div class="thirdGroundWork">
  <div class="tittleSection">
    <img src="<@spring.url '/css/siteStyle/iconBrand.png'/>" alt="" height="60px">
    <p class="titlesOfSections">Popular brands</p>
  </div>

  <div class="brandDiv">
    <nav>
      <ul class="nav_links">
        <li><img src="<@spring.url '/css/siteStyle/iconMountainRoseHerb.png'/>" alt="" width="200px"></li>
        <li><img src="<@spring.url '/css/siteStyle/iconBayer.png'/>" alt="" width="70px"></li>
        <li><img src="<@spring.url '/css/siteStyle/iconColoplast.webp'/>" alt="" width="200px" ></li>
        <li><img src="<@spring.url '/css/siteStyle/iconPfizer.svg'/>" alt="" width="100px"></li>
        <li><img src="<@spring.url '/css/siteStyle/iconPG.png'/>" alt="" width="150px"></li>
      </ul>
    </nav>
  </div>
</div>

<div class="footer">
  <div class="fourthGroundWork">
    <p id = "foot_text">
      500 Terry Francois Street.<br>
      San Francisco, CA 94158  |  1-800-000-0000<br>
    </p>

    <div class="social">
      <div class="icons child">
        <a href="https://web.telegram.org/" title="Twitter" target="_blank"><img src="<@spring.url '/css/siteStyle/iconTelegram.png'/>" alt="" width="36px" ></a>
      </div>
      <div class="icons child">
        <a href="https://www.viber.com/ru/" title="Viber" target="_blank"><img src="<@spring.url '/css/siteStyle/iconViber.png'/>" alt="" width="36px"></a>
      </div>
      <div class="icons child">
        <a href="https://www.facebook.com/" title="Facebook" target="_blank"><img src="<@spring.url '/css/siteStyle/facebook.png'/>" alt="" width="36px"></a>
      </div>
      <div class="icons child">
        <a href="https://www.instagram.com/" title="Instagram" target="_blank"><img src="<@spring.url '/css/siteStyle/instagram.png'/>" alt="" width="36px"></a>
      </div>
      <div class="child">
        <hr id="white">
      </div>
      <div class="child">
        <a class="ctu" href="#"><button class="button-23"><b id="b">Conta</b>ct&nbsp;us</button></a>
      </div>
    </div>
    <img class="footerImg" src="<@spring.url '/css/siteStyle/imgSelfMedication.png'/>" alt="" width="1400px">
    <p id="footerText">?? 2022 The information posted on the electronic medical information system pillsandpotions.ua
      is intended solely for informational purposes. Do not use the information on this site to diagnose,
      treat, cure or prevent any disease. Diagnosis and choice of treatment is carried out only by your doctor! More about the disclaimer.</p>
  </div>
</div>


</body>
</html>