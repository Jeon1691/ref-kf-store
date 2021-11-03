<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="mArticle">
  <h2 class="screen_out">global shipping information</h2>
  <div class="global_intro">
    <div class="inner_intro">
      <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/global_introen_170515.png" class="rw_hide" alt="">
      <strong>The Kakao Friends take on international travel. All around the world with global delivery.</strong>
      <p>Crossing timezones to see their friends from across the globe!</p>
    </div>
  </div>
  <div class="global_info">
    <strong class="tit_info">Kakao Friends Global Shipping?</strong>
    <p class="desc_info">
      Kakao Friends have launched a global shipping service.<br><br class="rw_hide">
      Our global shipping agency is the government-run Korea Post; using our service, however, is much easier than<br class="rw_show">
      independently shipping internationally through the post office.<br><br class="rw_hide">
      The Kakao Friends Global Delivery service is currently available for 52 countries worldwide,<br class="rw_show">
      but stay tuned for our expansion as we add more countries to the list.
    </p>
  </div>
  <div class="tab_menu">
    <strong class="screen_out">global shipping information menu</strong>
    <div class="wrap_scroll">
      <ul class="list_tab">
        <li class="on"><a href="#tabInfo1" class="link_tab">How To Use</a></li>
        <li><a href="#tabInfo2" class="link_tab">Process</a></li>
        <li><a href="#tabInfo3" class="link_tab">Information</a></li>
        <li><a href="#tabInfo4" class="link_tab">Fees</a></li>
        <li><a href="#tabInfo5" class="link_tab">Deliver To</a></li>
      </ul>
    </div>
  </div>
  <div id="tabInfo1" class="tab_cont" style="display:block">
    <h3 class="screen_out">How To Use</h3>
    <div class="use_info use_step1">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step1_en.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 1 Check to see which products can be shipped internationally</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">You can filter your search results by marking the option to view products eligible for international delivery.</span>
      </li>
      <li>
        <span class="num_item">2</span><span class="txt_use">Products eligible for international delivery will be accompanied by a blue global shipping icon.</span>
      </li>
    </ul>
    <div class="use_info use_step2">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step2_en.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 2 Purchasing an item from the product detail page</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">First check to see that the product can be shipped internationally before proceeding with your purchase.</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub2_en.png" class="rw_hide" alt="">
        <span class="num_item">2</span><span class="txt_use">Selecting the area that indicates global shipping eligibility will lead you to a pop-up window with further details about the countries we ship to.</span>
      </li>
    </ul>
    <div class="use_info use_step3">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step3_en.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 3 Purchasing an item from your shopping cart</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">You can also select the destination country from the shopping cart.</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub3_en.png" class="rw_hide" alt="">
        <span class="num_item">2</span><span class="txt_use">If there are any items within the shopping cart that are not eligible for international shipping, then you will not be able to proceed to checkout, so please check before you select.</span>
      </li>
    </ul>
    <div class="use_info use_step4">
      <div class="inner_use"><img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_step4_en.png" class="rw_hide" alt=""></div>
    </div>
    <strong class="screen_out">Step. 4 Entering your orders and shipping information</strong>
    <ul class="list_use">
      <li>
        <span class="num_item">1</span><span class="txt_use">You can also select the destination country on the checkout screen.</span>
      </li>
      <li>
        <span class="num_item">2</span><span class="txt_use">If you select an overseas shipping location, the form will change accordingly. Please enter overseas shipping information in English.</span>
      </li>
      <li>
        <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/img_stepsub4_en.png" class="rw_hide" alt="">
        <span class="num_item">3</span><span class="txt_use">If you change your shipping location to an overseas location from the checkout screen, and there are items in the shopping cart that are not eligible for international shipping, then you will not be able to finalize your purchase.</span>
      </li>
      <li>
        <span class="num_item">4</span><span class="txt_use">When you have made a successful purchase you will receive information on your order via the email address you entered.</span>
      </li>
    </ul>
  </div>
  <div id="tabInfo2" class="tab_cont">
    <h3 class="screen_out">Process</h3>
    <div class="cont_subject">
      <img src="https://t1.daumcdn.net/friends/www/resources/images/m640/global_step_en_171024.png" class="rw_hide" alt="">
      <strong class="screen_out">Shipping order</strong>
      <ol class="list_step">
        <li>Step. 1 Order received (Domestic shipping status)</li>
        <li>Step. 2 Preparing to ship (Domestic shipping status)</li>
        <li>Step. 3 Preparing to ship overseas (Domestic shipping status)</li>
        <li>Step. 4 Tracking number updated (Domestic shipping status)</li>
        <li>Step. 5 En route (Global shipping status)</li>
        <li>Step. 6 Delivery complete (Global shipping status)</li>
      </ol>
      <p class="desc_global"><span class="ico_friends ico_bullet"></span>You can track your order live by going to the <span class="txt_g">&rdquo;</span>
        <sec:authorize access="isAnonymous()">
          <a href="javascript:loginPopup();" class="link_global">My Page &gt; Order List</a>
        </sec:authorize>
        <sec:authorize access="isFullyAuthenticated()">
          <a href="/en/mypage/orderlist" class="link_global">My Page &gt; Order List</a>
        </sec:authorize>
        <span class="txt_g">&rdquo;</span>.</p>
    </div>
  </div>

  <div id="tabInfo3" class="tab_cont">
    <h3 class="screen_out">Information</h3>
    <div class="cont_subject cont_notice">
      <h4 class="tit_notice">Shipping information</h4>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>EMS notice</strong>
          <p class="desc_notice">
            If the items being shipped fall under either of the two restrictions below, even if there are no issues with domestic shipping, the orders will be split into multiple parts according to the specifications of the international shipping companies.<br class="rw_show">
            Under these circumstances, please keep in mind that there may be additional charges for the domestic or international leg of the delivery.
          </p>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>Weight restrictions: Items must be 30 kg or less <span class="txt_g">(20 kg for certain countries)</span>
          </em>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>Size restrictions: Restrictions may apply depending on the destination country.
          </em>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span>Customs</strong>
          <p class="desc_notice">
            Customs fees, taxes and other expenses are not included in the price of delivery. Payment of these additional expenses is the burden of the buyer upon receiving the package.
          </p>
          <em class="emph_notice"><span class="ico_friends ico_bullet"></span>Please contact your local post office or customs office for more detailed and precise information on taxes.</em>
          <div class="wrap_btn">
            <a href="http://ems.epost.go.kr/front.EmsDeliveryDelivery02.postal" class="btn_notice" target="_blank">EMS Information</a>
            <a href="http://post.customs.go.kr/" class="btn_notice" target="_blank">Korea Customs Service</a>
          </div>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">3</span>Delays</strong>
          <p class="desc_notice">
            The global delivery of the entire order may be delayed if even several of the items have not arrived at the delivery location.<br>
            Please direct all questions about global shipments to the <em class="emph_g">Contact Us</em> service or email <em class="emph_g">global@kakaofriends.com</em>.
          </p>
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="btn_notice">Contact Us</a>
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/en/mypage/onetoone" class="btn_notice">Contact Us</a>
          </sec:authorize>
        </li>
      </ul>
      <h4 class="tit_notice">Product information</h4>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>Information on cancellations/returns/exchanges</strong>

          <p class="desc_notice">
            You can cancel your purchase as long as it is still in the &ldquo;order received&rdquo; stage. Unlike domestic orders, international orders are final, without returns, exchanges or any further opportunities to cancel the order.<br>
            Please be aware that we not accept returns or exchanges without special cause once the item has been delivered to its overseas destination, and think carefully before making your purchase.<br>
            Regarding exchanges due to defects in the product, please direct your inquiries to <em class="emph_g">Contact Us</em> or email <em class="emph_g">global@kakaofriends.com</em>.
          </p>
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="btn_notice">Contact Us</a>
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/en/mypage/onetoone" class="btn_notice">Contact Us</a>
          </sec:authorize>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span>Customs clearance and fees</strong>

          <p class="desc_notice">
            The South Korean customs office will sometimes impose a customs tax or additional tax on certain items shipped from overseas.<br>
            Likewise, depending on the destination, items shipped from South Korea to certain countries may be taxed according to local regulations.<br>
            The burden of the tax falls upon the individual who receives the item. However, excluding extraordinary circumstances, gift items are generally not taxed.
          </p>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">3</span>Information on purchasing electronics</strong>
          <p class="desc_notice">
            When purchasing electronic products, please check the voltage and current of the item, and ensure that the product is compatible with the electrical system in the destination country.<br>
            The buyer is responsible for any issues that arise from purchasing or using the wrong product.
          </p>
        </li>
      </ul>
      <h4 class="tit_notice">Information on destination countries</h4>
      <p class="desc_country">
        In the case of electronic products, please check each individual product to ensure that the product is compatible with the electricity in the destination country before making a purchase.<br>
        If the buyer should happen to order a product without checking for compatibility, and ends up receiving a product that is incompatible with the electricity of their country of residency, any costs for the return of the product are the burden of the buyer.<br>
        In the case of a return due to an error in the delivery of the product, or due to a defect in the product itself, please use the local or regional postal service of the destination country. If the buyer returns the product via another international shipping service,
        the buyer must shoulder the additional burden of any taxes imposed by the South Korean customs authorities.
      </p>
      <ul class="list_notice">
        <li>
          <strong class="tit_item"><span class="num_item">1</span>Products that cannot be shipped globally</strong>
          <p class="desc_notice">
            Excessively heavy or large products<br>
            Products with the potential to spoil (whether foodstuffs, or products with the potential to pollute or damage other goods)<br>
            Inappropriate products, the importing and/or distribution of which are banned in the destination country (counterfeit products, banned products, dangerous products, gold and other precious metals, etc., with regulations varying by country)<br>
            Explosive and/or flammable products, and other dangerous substances (sprays, burners, etc.)
          </p>
          <em class="emph_notice">
            <span class="ico_friends ico_bullet"></span>For a more detailed and comprehensive list, please check the customs information for each country, below, or ask your local post office or customs office.
          </em>
        </li>
        <li>
          <strong class="tit_item"><span class="num_item">2</span> Important considerations for each country</strong>
          <p class="desc_notice">For a list of banned or restricted items in each country, please refer to the customs information for the country in question, below.</p>
          <a href="http://ems.epost.go.kr/front.EmsSurveySurvey01.postal" class="btn_notice" target="_blank">Customs information by country</a>
        </li>
      </ul>
    </div>
  </div>

  <div id="tabInfo4" class="tab_cont">
    <h3 class="screen_out">Fees</h3>
    <div class="cont_subject cont_fare">
      <h4 class="tit_item"><span class="num_item">1</span> EMS international courier service</h4>
      <p class="desc_notice">
        <span class="txt_notice">International shipping - Up to 30 kg<br class="rw_show"></span>
        <span class="txt_notice">The EMS shipping fee is calculated by weight, including the weight of the shipping box as well as the product.<br class="rw_show"></span>
        <span class="txt_notice">You can check the delivery status of products sent via EMS by going to
          <sec:authorize access="isAnonymous()">
            <a href="javascript:loginPopup();" class="link_global">&lsquo; My Page &gt; My Orders &rsquo;</a>.
          </sec:authorize>
          <sec:authorize access="isFullyAuthenticated()">
            <a href="/en/mypage/orderlist" class="link_global">&lsquo; My Page &gt; My Orders &rsquo;</a>.
          </sec:authorize>
        </span>
      </p>
      <a href="http://ems.epost.go.kr/front.EmsDeliveryDelivery02.postal" class="btn_notice" target="_blank">EMS Information</a>
      <h4 class="tit_item"><span class="num_item">2</span> Countries we deliver to, by area</h4>
      <!-- 2017-07-10 수정 -->
      <dl class="list_item">
        <dt>Special Area :</dt>
        <dd>New Zealand, Germany, Taiwan, Russia, Malaysia, United States, Brazil, Vietnam  Spain, Singapore, United Kingdom, Indonesia, Japan, China, Canada, Thailand, Philippines, Australia, Hong Kong</dd>
        <dt>Area 1 :</dt>
        <dd>Laos, Macao, Myanmar</dd>
        <dt>Area 2 :</dt>
        <dd>Brunei, India</dd>
        <dt>Area 3 :</dt>
        <dd>Netherlands, Norway, Denmark, Romania, Belgium, Saudi Arabia, Sweden, Switzerland, Slovakia, United Arab Emirates, Ireland, Austria, Uzbekistan, Israel, Czech, Portugal, Poland, Finland, Qatar, Croatia, Turkey</dd>
        <dt>Area 4 :</dt>
        <dd>Mexico, Morocco, Argentina, Chile, Kenya, Peru</dd>
      </dl>
      <!-- // 2017-07-10 수정 -->
      <h4 class="tit_item"><span class="num_item">3</span> Shipping fees, by weight and area</h4>
      <div class="wrap_table">
        <div id="tableItem1" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">Australia, Brazil, Canada, China Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">Australia</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Brazil</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Canada</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">China</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>23,000<span class="screen_out">KRW</span></td><td>32,000<span class="screen_out">KRW</span></td><td>29,000<span class="screen_out">KRW</span></td><td>23,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>26,000<span class="screen_out">KRW</span></td><td>35,000<span class="screen_out">KRW</span></td><td>31,000<span class="screen_out">KRW</span></td><td>25,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>29,000<span class="screen_out">KRW</span></td><td>38,000<span class="screen_out">KRW</span></td><td>33,000<span class="screen_out">KRW</span></td><td>26,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>32,000<span class="screen_out">KRW</span></td><td>41,000<span class="screen_out">KRW</span></td><td>35,000<span class="screen_out">KRW</span></td><td>28,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>35,000<span class="screen_out">KRW</span></td><td>44,500<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td><td>30,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>38,500<span class="screen_out">KRW</span></td><td>47,500<span class="screen_out">KRW</span></td><td>39,500<span class="screen_out">KRW</span></td><td>31,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>41,500<span class="screen_out">KRW</span></td><td>50,500<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>46,500<span class="screen_out">KRW</span></td><td>56,500<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td><td>34,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>51,000<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td><td>49,000<span class="screen_out">KRW</span></td><td>35,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>56,000<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td><td>53,000<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>60,500<span class="screen_out">KRW</span></td><td>74,000<span class="screen_out">KRW</span></td><td>57,000<span class="screen_out">KRW</span></td><td>39,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>65,500<span class="screen_out">KRW</span></td><td>79,500<span class="screen_out">KRW</span></td><td>60,500<span class="screen_out">KRW</span></td><td>40,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>70,000<span class="screen_out">KRW</span></td><td>87,500<span class="screen_out">KRW</span></td><td>64,500<span class="screen_out">KRW</span></td><td>42,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>75,000<span class="screen_out">KRW</span></td><td>95,500<span class="screen_out">KRW</span></td><td>68,500<span class="screen_out">KRW</span></td><td>44,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>80,000<span class="screen_out">KRW</span></td><td>103,500<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>84,500<span class="screen_out">KRW</span></td><td>111,500<span class="screen_out">KRW</span></td><td>76,500<span class="screen_out">KRW</span></td><td>47,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>89,500<span class="screen_out">KRW</span></td><td>119,500<span class="screen_out">KRW</span></td><td>80,500<span class="screen_out">KRW</span></td><td>48,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>94,000<span class="screen_out">KRW</span></td><td>128,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td><td>50,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>99,000<span class="screen_out">KRW</span></td><td>136,000<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td><td>52,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>104,000<span class="screen_out">KRW</span></td><td>144,000<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td><td>53,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>108,500<span class="screen_out">KRW</span></td><td>152,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>55,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>113,500<span class="screen_out">KRW</span></td><td>160,000<span class="screen_out">KRW</span></td><td>101,500<span class="screen_out">KRW</span></td><td>57,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>118,000<span class="screen_out">KRW</span></td><td>168,000<span class="screen_out">KRW</span></td><td>105,500<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>123,000<span class="screen_out">KRW</span></td><td>176,000<span class="screen_out">KRW</span></td><td>110,000<span class="screen_out">KRW</span></td><td>60,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>127,500<span class="screen_out">KRW</span></td><td>184,000<span class="screen_out">KRW</span></td><td>114,000<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>132,500<span class="screen_out">KRW</span></td><td>192,000<span class="screen_out">KRW</span></td><td>118,500<span class="screen_out">KRW</span></td><td>63,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>137,500<span class="screen_out">KRW</span></td><td>200,000<span class="screen_out">KRW</span></td><td>122,500<span class="screen_out">KRW</span></td><td>65,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>142,000<span class="screen_out">KRW</span></td><td>208,000<span class="screen_out">KRW</span></td><td>126,500<span class="screen_out">KRW</span></td><td>67,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>147,000<span class="screen_out">KRW</span></td><td>216,000<span class="screen_out">KRW</span></td><td>131,000<span class="screen_out">KRW</span></td><td>68,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>151,500<span class="screen_out">KRW</span></td><td>224,000<span class="screen_out">KRW</span></td><td>135,000<span class="screen_out">KRW</span></td><td>70,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>156,500<span class="screen_out">KRW</span></td><td>232,000<span class="screen_out">KRW</span></td><td>139,500<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>161,500<span class="screen_out">KRW</span></td><td>240,000<span class="screen_out">KRW</span></td><td>143,500<span class="screen_out">KRW</span></td><td>73,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>166,000<span class="screen_out">KRW</span></td><td>248,000<span class="screen_out">KRW</span></td><td>148,000<span class="screen_out">KRW</span></td><td>75,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>171,000<span class="screen_out">KRW</span></td><td>256,000<span class="screen_out">KRW</span></td><td>152,000<span class="screen_out">KRW</span></td><td>76,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>175,500<span class="screen_out">KRW</span></td><td>264,000<span class="screen_out">KRW</span></td><td>156,000<span class="screen_out">KRW</span></td><td>78,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>180,500<span class="screen_out">KRW</span></td><td>272,000<span class="screen_out">KRW</span></td><td>160,500<span class="screen_out">KRW</span></td><td>80,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>185,000<span class="screen_out">KRW</span></td><td>280,000<span class="screen_out">KRW</span></td><td>164,500<span class="screen_out">KRW</span></td><td>82,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>190,000<span class="screen_out">KRW</span></td><td>288,000<span class="screen_out">KRW</span></td><td>169,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>195,000<span class="screen_out">KRW</span></td><td>296,000<span class="screen_out">KRW</span></td><td>173,000<span class="screen_out">KRW</span></td><td>86,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>199,500<span class="screen_out">KRW</span></td><td>304,500<span class="screen_out">KRW</span></td><td>177,000<span class="screen_out">KRW</span></td><td>88,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>204,500<span class="screen_out">KRW</span></td><td>312,500<span class="screen_out">KRW</span></td><td>181,500<span class="screen_out">KRW</span></td><td>90,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>209,000<span class="screen_out">KRW</span></td><td>320,500<span class="screen_out">KRW</span></td><td>185,500<span class="screen_out">KRW</span></td><td>92,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>214,000<span class="screen_out">KRW</span></td><td>328,500<span class="screen_out">KRW</span></td><td>190,000<span class="screen_out">KRW</span></td><td>94,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>219,000<span class="screen_out">KRW</span></td><td>336,500<span class="screen_out">KRW</span></td><td>194,000<span class="screen_out">KRW</span></td><td>96,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>223,500<span class="screen_out">KRW</span></td><td>344,500<span class="screen_out">KRW</span></td><td>198,000<span class="screen_out">KRW</span></td><td>98,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>228,500<span class="screen_out">KRW</span></td><td>352,500<span class="screen_out">KRW</span></td><td>202,500<span class="screen_out">KRW</span></td><td>100,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>233,000<span class="screen_out">KRW</span></td><td>360,500<span class="screen_out">KRW</span></td><td>206,500<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>238,000<span class="screen_out">KRW</span></td><td>368,500<span class="screen_out">KRW</span></td><td>211,000<span class="screen_out">KRW</span></td><td>103,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>243,000<span class="screen_out">KRW</span></td><td>376,500<span class="screen_out">KRW</span></td><td>215,000<span class="screen_out">KRW</span></td><td>105,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>247,500<span class="screen_out">KRW</span></td><td>384,500<span class="screen_out">KRW</span></td><td>219,000<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>252,500<span class="screen_out">KRW</span></td><td>392,500<span class="screen_out">KRW</span></td><td>223,500<span class="screen_out">KRW</span></td><td>109,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>257,000<span class="screen_out">KRW</span></td><td>400,500<span class="screen_out">KRW</span></td><td>227,500<span class="screen_out">KRW</span></td><td>111,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>262,000<span class="screen_out">KRW</span></td><td>408,500<span class="screen_out">KRW</span></td><td>232,000<span class="screen_out">KRW</span></td><td>113,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>266,500<span class="screen_out">KRW</span></td><td>416,500<span class="screen_out">KRW</span></td><td>236,000<span class="screen_out">KRW</span></td><td>115,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>271,500<span class="screen_out">KRW</span></td><td>424,500<span class="screen_out">KRW</span></td><td>240,000<span class="screen_out">KRW</span></td><td>117,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>276,500<span class="screen_out">KRW</span></td><td>432,500<span class="screen_out">KRW</span></td><td>244,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>281,000<span class="screen_out">KRW</span></td><td>440,500<span class="screen_out">KRW</span></td><td>248,500<span class="screen_out">KRW</span></td><td>121,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>286,000<span class="screen_out">KRW</span></td><td>448,500<span class="screen_out">KRW</span></td><td>253,000<span class="screen_out">KRW</span></td><td>123,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>290,500<span class="screen_out">KRW</span></td><td>456,500<span class="screen_out">KRW</span></td><td>257,000<span class="screen_out">KRW</span></td><td>125,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>295,500<span class="screen_out">KRW</span></td><td>464,500<span class="screen_out">KRW</span></td><td>261,500<span class="screen_out">KRW</span></td><td>127,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>300,500<span class="screen_out">KRW</span></td><td>472,500<span class="screen_out">KRW</span></td><td>265,500<span class="screen_out">KRW</span></td><td>129,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>305,000<span class="screen_out">KRW</span></td><td>481,000<span class="screen_out">KRW</span></td><td>269,500<span class="screen_out">KRW</span></td><td>130,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>310,000<span class="screen_out">KRW</span></td><td>489,000<span class="screen_out">KRW</span></td><td>274,000<span class="screen_out">KRW</span></td><td>132,500<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem1" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>

        <div id="tableItem2" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">Germany, Hong Kong, Indonesia Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <%--<th class="col_type2" scope="col"><span class="txt_region">France</span></th>--%>
              <th class="col_type2" scope="col"><span class="txt_region">Germany</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Hong Kong</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Indonesia</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">United States</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td> 30,500<span class="screen_out">KRW</span></td><td>22,500<span class="screen_out">KRW</span></td><td>19,000<span class="screen_out">KRW</span></td><td>26,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td> 33,000<span class="screen_out">KRW</span></td><td>23,500<span class="screen_out">KRW</span></td><td>20,000<span class="screen_out">KRW</span></td><td>30,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td> 35,000<span class="screen_out">KRW</span></td><td>24,500<span class="screen_out">KRW</span></td><td>21,000<span class="screen_out">KRW</span></td><td>33,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td> 37,000<span class="screen_out">KRW</span></td><td>25,500<span class="screen_out">KRW</span></td><td>22,500<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td> 39,000<span class="screen_out">KRW</span></td><td>26,500<span class="screen_out">KRW</span></td><td>23,500<span class="screen_out">KRW</span></td><td>40,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td> 41,000<span class="screen_out">KRW</span></td><td>27,500<span class="screen_out">KRW</span></td><td>24,500<span class="screen_out">KRW</span></td><td>44,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td> 43,500<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td><td>25,500<span class="screen_out">KRW</span></td><td>47,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td> 47,000<span class="screen_out">KRW</span></td><td>30,000<span class="screen_out">KRW</span></td><td>27,500<span class="screen_out">KRW</span></td><td>54,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td> 50,500<span class="screen_out">KRW</span></td><td>31,500<span class="screen_out">KRW</span></td><td>30,000<span class="screen_out">KRW</span></td><td>61,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td> 54,000<span class="screen_out">KRW</span></td><td>33,000<span class="screen_out">KRW</span></td><td>32,000<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td> 58,000<span class="screen_out">KRW</span></td><td>34,500<span class="screen_out">KRW</span></td><td>34,000<span class="screen_out">KRW</span></td><td>74,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td> 61,500<span class="screen_out">KRW</span></td><td>35,500<span class="screen_out">KRW</span></td><td>36,000<span class="screen_out">KRW</span></td><td>81,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td> 65,000<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td><td>38,000<span class="screen_out">KRW</span></td><td>88,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td> 68,500<span class="screen_out">KRW</span></td><td>38,500<span class="screen_out">KRW</span></td><td>40,000<span class="screen_out">KRW</span></td><td>95,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td> 72,500<span class="screen_out">KRW</span></td><td>40,000<span class="screen_out">KRW</span></td><td>42,000<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td> 76,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>44,000<span class="screen_out">KRW</span></td><td>108,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td> 80,000<span class="screen_out">KRW</span></td><td>43,000<span class="screen_out">KRW</span></td><td>46,000<span class="screen_out">KRW</span></td><td>115,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td> 84,500<span class="screen_out">KRW</span></td><td>44,500<span class="screen_out">KRW</span></td><td>48,000<span class="screen_out">KRW</span></td><td>122,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td> 88,500<span class="screen_out">KRW</span></td><td>46,000<span class="screen_out">KRW</span></td><td>50,000<span class="screen_out">KRW</span></td><td>129,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td> 93,000<span class="screen_out">KRW</span></td><td>48,000<span class="screen_out">KRW</span></td><td>52,000<span class="screen_out">KRW</span></td><td>135,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td> 97,000<span class="screen_out">KRW</span></td><td>50,000<span class="screen_out">KRW</span></td><td>54,000<span class="screen_out">KRW</span></td><td>142,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td> 101,000<span class="screen_out">KRW</span></td><td>52,000<span class="screen_out">KRW</span></td><td>56,000<span class="screen_out">KRW</span></td><td>149,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td> 105,500<span class="screen_out">KRW</span></td><td>54,000<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td><td>156,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td> 109,500<span class="screen_out">KRW</span></td><td>56,000<span class="screen_out">KRW</span></td><td>61,500<span class="screen_out">KRW</span></td><td>163,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td> 114,000<span class="screen_out">KRW</span></td><td>58,000<span class="screen_out">KRW</span></td><td>64,000<span class="screen_out">KRW</span></td><td>169,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td> 118,000<span class="screen_out">KRW</span></td><td>60,000<span class="screen_out">KRW</span></td><td>67,000<span class="screen_out">KRW</span></td><td>176,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td> 122,500<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td><td>69,500<span class="screen_out">KRW</span></td><td>183,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td> 126,500<span class="screen_out">KRW</span></td><td>64,000<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td><td>190,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td> 130,500<span class="screen_out">KRW</span></td><td>66,000<span class="screen_out">KRW</span></td><td>75,000<span class="screen_out">KRW</span></td><td>197,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td> 135,000<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td><td>203,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td> 139,000<span class="screen_out">KRW</span></td><td>70,000<span class="screen_out">KRW</span></td><td>80,500<span class="screen_out">KRW</span></td><td>210,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td> 143,500<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td><td>83,000<span class="screen_out">KRW</span></td><td>217,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td> 147,500<span class="screen_out">KRW</span></td><td>74,000<span class="screen_out">KRW</span></td><td>86,000<span class="screen_out">KRW</span></td><td>224,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td> 152,000<span class="screen_out">KRW</span></td><td>76,000<span class="screen_out">KRW</span></td><td>88,500<span class="screen_out">KRW</span></td><td>231,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td> 156,000<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td><td>91,500<span class="screen_out">KRW</span></td><td>237,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td> 160,500<span class="screen_out">KRW</span></td><td>79,500<span class="screen_out">KRW</span></td><td>94,000<span class="screen_out">KRW</span></td><td>244,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td> 164,500<span class="screen_out">KRW</span></td><td>81,500<span class="screen_out">KRW</span></td><td>97,000<span class="screen_out">KRW</span></td><td>251,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td> 168,500<span class="screen_out">KRW</span></td><td>83,500<span class="screen_out">KRW</span></td><td>99,500<span class="screen_out">KRW</span></td><td>258,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td> 173,000<span class="screen_out">KRW</span></td><td>85,500<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td><td>264,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td> 177,000<span class="screen_out">KRW</span></td><td>87,500<span class="screen_out">KRW</span></td><td>105,000<span class="screen_out">KRW</span></td><td>271,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td> 181,500<span class="screen_out">KRW</span></td><td>89,500<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td><td>278,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td> 185,500<span class="screen_out">KRW</span></td><td>91,500<span class="screen_out">KRW</span></td><td>110,500<span class="screen_out">KRW</span></td><td>285,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td> 190,000<span class="screen_out">KRW</span></td><td>93,500<span class="screen_out">KRW</span></td><td>113,000<span class="screen_out">KRW</span></td><td>292,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td> 194,000<span class="screen_out">KRW</span></td><td>95,500<span class="screen_out">KRW</span></td><td>116,000<span class="screen_out">KRW</span></td><td>298,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td> 198,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>118,500<span class="screen_out">KRW</span></td><td>305,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td> 202,500<span class="screen_out">KRW</span></td><td>99,500<span class="screen_out">KRW</span></td><td>121,500<span class="screen_out">KRW</span></td><td>312,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td> 206,500<span class="screen_out">KRW</span></td><td>101,500<span class="screen_out">KRW</span></td><td>124,000<span class="screen_out">KRW</span></td><td>319,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td> 211,000<span class="screen_out">KRW</span></td><td>103,500<span class="screen_out">KRW</span></td><td>126,500<span class="screen_out">KRW</span></td><td>326,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td> 215,000<span class="screen_out">KRW</span></td><td>105,500<span class="screen_out">KRW</span></td><td>129,500<span class="screen_out">KRW</span></td><td>332,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td> 219,500<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td><td>132,000<span class="screen_out">KRW</span></td><td>339,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td> 223,500<span class="screen_out">KRW</span></td><td>109,500<span class="screen_out">KRW</span></td><td>135,000<span class="screen_out">KRW</span></td><td>346,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td> 228,000<span class="screen_out">KRW</span></td><td>111,500<span class="screen_out">KRW</span></td><td>137,500<span class="screen_out">KRW</span></td><td>353,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td> 232,000<span class="screen_out">KRW</span></td><td>113,500<span class="screen_out">KRW</span></td><td>140,500<span class="screen_out">KRW</span></td><td>360,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td> 236,000<span class="screen_out">KRW</span></td><td>115,500<span class="screen_out">KRW</span></td><td>143,000<span class="screen_out">KRW</span></td><td>366,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td> 240,500<span class="screen_out">KRW</span></td><td>117,000<span class="screen_out">KRW</span></td><td>146,000<span class="screen_out">KRW</span></td><td>373,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td> 244,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td><td>148,500<span class="screen_out">KRW</span></td><td>380,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td> 249,000<span class="screen_out">KRW</span></td><td>121,000<span class="screen_out">KRW</span></td><td>151,500<span class="screen_out">KRW</span></td><td>387,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td> 253,000<span class="screen_out">KRW</span></td><td>123,000<span class="screen_out">KRW</span></td><td>154,000<span class="screen_out">KRW</span></td><td>393,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td> 257,500<span class="screen_out">KRW</span></td><td>125,000<span class="screen_out">KRW</span></td><td>156,500<span class="screen_out">KRW</span></td><td>400,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td> 261,500<span class="screen_out">KRW</span></td><td>127,000<span class="screen_out">KRW</span></td><td>159,500<span class="screen_out">KRW</span></td><td>407,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td> 265,500<span class="screen_out">KRW</span></td><td>129,000<span class="screen_out">KRW</span></td><td>162,000<span class="screen_out">KRW</span></td><td>414,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td> 270,000<span class="screen_out">KRW</span></td><td>131,000<span class="screen_out">KRW</span></td><td>165,000<span class="screen_out">KRW</span></td><td>421,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td> 274,000<span class="screen_out">KRW</span></td><td>133,000<span class="screen_out">KRW</span></td><td>167,500<span class="screen_out">KRW</span></td><td>427,500<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem2" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
      </div>

      <div class="wrap_table">
        <div id="tableItem3" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">Japan, Malaysia, New Zealand, Philippines Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">Japan</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Malaysia</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">New Zealand</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Philippines</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>23,500<span class="screen_out">KRW</span></td><td>17,500<span class="screen_out">KRW</span></td><td>23,500<span class="screen_out">KRW</span></td><td>18,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>24,500<span class="screen_out">KRW</span></td><td>19,000<span class="screen_out">KRW</span></td><td>26,000<span class="screen_out">KRW</span></td><td>19,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>25,500<span class="screen_out">KRW</span></td><td>20,500<span class="screen_out">KRW</span></td><td>28,000<span class="screen_out">KRW</span></td><td>20,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>27,500<span class="screen_out">KRW</span></td><td>22,000<span class="screen_out">KRW</span></td><td>30,500<span class="screen_out">KRW</span></td><td>21,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>28,500<span class="screen_out">KRW</span></td><td>23,500<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td><td>23,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>31,000<span class="screen_out">KRW</span></td><td>25,000<span class="screen_out">KRW</span></td><td>35,000<span class="screen_out">KRW</span></td><td>24,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>33,000<span class="screen_out">KRW</span></td><td>26,500<span class="screen_out">KRW</span></td><td>37,500<span class="screen_out">KRW</span></td><td>25,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>34,500<span class="screen_out">KRW</span></td><td>29,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>26,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>36,500<span class="screen_out">KRW</span></td><td>31,500<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>38,000<span class="screen_out">KRW</span></td><td>34,000<span class="screen_out">KRW</span></td><td>50,000<span class="screen_out">KRW</span></td><td>30,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>40,000<span class="screen_out">KRW</span></td><td>36,500<span class="screen_out">KRW</span></td><td>54,000<span class="screen_out">KRW</span></td><td>32,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>41,500<span class="screen_out">KRW</span></td><td>39,000<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td><td>33,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>43,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>62,500<span class="screen_out">KRW</span></td><td>35,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>45,000<span class="screen_out">KRW</span></td><td>44,000<span class="screen_out">KRW</span></td><td>67,000<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>46,500<span class="screen_out">KRW</span></td><td>46,500<span class="screen_out">KRW</span></td><td>71,000<span class="screen_out">KRW</span></td><td>39,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>48,500<span class="screen_out">KRW</span></td><td>49,000<span class="screen_out">KRW</span></td><td>75,500<span class="screen_out">KRW</span></td><td>40,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>50,000<span class="screen_out">KRW</span></td><td>51,500<span class="screen_out">KRW</span></td><td>80,000<span class="screen_out">KRW</span></td><td>42,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>51,500<span class="screen_out">KRW</span></td><td>54,500<span class="screen_out">KRW</span></td><td>84,000<span class="screen_out">KRW</span></td><td>44,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>53,500<span class="screen_out">KRW</span></td><td>57,000<span class="screen_out">KRW</span></td><td>88,500<span class="screen_out">KRW</span></td><td>46,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>55,000<span class="screen_out">KRW</span></td><td>60,000<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td><td>48,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>57,000<span class="screen_out">KRW</span></td><td>63,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>50,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>58,500<span class="screen_out">KRW</span></td><td>66,000<span class="screen_out">KRW</span></td><td>101,500<span class="screen_out">KRW</span></td><td>53,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>60,000<span class="screen_out">KRW</span></td><td>68,500<span class="screen_out">KRW</span></td><td>106,000<span class="screen_out">KRW</span></td><td>55,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>62,000<span class="screen_out">KRW</span></td><td>71,500<span class="screen_out">KRW</span></td><td>110,500<span class="screen_out">KRW</span></td><td>57,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>63,500<span class="screen_out">KRW</span></td><td>74,500<span class="screen_out">KRW</span></td><td>115,000<span class="screen_out">KRW</span></td><td>59,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>65,500<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td><td>61,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>67,000<span class="screen_out">KRW</span></td><td>80,000<span class="screen_out">KRW</span></td><td>123,500<span class="screen_out">KRW</span></td><td>63,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>69,000<span class="screen_out">KRW</span></td><td>83,000<span class="screen_out">KRW</span></td><td>128,000<span class="screen_out">KRW</span></td><td>65,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>70,500<span class="screen_out">KRW</span></td><td>86,000<span class="screen_out">KRW</span></td><td>132,000<span class="screen_out">KRW</span></td><td>67,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>71,500<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td><td>136,500<span class="screen_out">KRW</span></td><td>69,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>73,500<span class="screen_out">KRW</span></td><td>92,000<span class="screen_out">KRW</span></td><td>141,000<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>75,000<span class="screen_out">KRW</span></td><td>94,500<span class="screen_out">KRW</span></td><td>145,500<span class="screen_out">KRW</span></td><td>74,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>76,500<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>149,500<span class="screen_out">KRW</span></td><td>76,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>78,000<span class="screen_out">KRW</span></td><td>100,500<span class="screen_out">KRW</span></td><td>154,000<span class="screen_out">KRW</span></td><td>78,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>79,500<span class="screen_out">KRW</span></td><td>103,500<span class="screen_out">KRW</span></td><td>158,500<span class="screen_out">KRW</span></td><td>80,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>81,000<span class="screen_out">KRW</span></td><td>106,000<span class="screen_out">KRW</span></td><td>163,000<span class="screen_out">KRW</span></td><td>82,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>82,500<span class="screen_out">KRW</span></td><td>109,000<span class="screen_out">KRW</span></td><td>167,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>84,000<span class="screen_out">KRW</span></td><td>112,000<span class="screen_out">KRW</span></td><td>171,500<span class="screen_out">KRW</span></td><td>86,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>85,500<span class="screen_out">KRW</span></td><td>115,000<span class="screen_out">KRW</span></td><td>176,000<span class="screen_out">KRW</span></td><td>88,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>87,000<span class="screen_out">KRW</span></td><td>117,500<span class="screen_out">KRW</span></td><td>180,500<span class="screen_out">KRW</span></td><td>91,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>88,500<span class="screen_out">KRW</span></td><td>120,500<span class="screen_out">KRW</span></td><td>184,500<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>90,000<span class="screen_out">KRW</span></td><td>123,500<span class="screen_out">KRW</span></td><td>189,000<span class="screen_out">KRW</span></td><td>95,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>91,500<span class="screen_out">KRW</span></td><td>126,500<span class="screen_out">KRW</span></td><td>193,500<span class="screen_out">KRW</span></td><td>97,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>93,000<span class="screen_out">KRW</span></td><td>129,500<span class="screen_out">KRW</span></td><td>197,500<span class="screen_out">KRW</span></td><td>99,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>94,500<span class="screen_out">KRW</span></td><td>132,000<span class="screen_out">KRW</span></td><td>202,000<span class="screen_out">KRW</span></td><td>101,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>96,000<span class="screen_out">KRW</span></td><td>135,000<span class="screen_out">KRW</span></td><td>206,500<span class="screen_out">KRW</span></td><td>103,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>97,500<span class="screen_out">KRW</span></td><td>138,000<span class="screen_out">KRW</span></td><td>211,000<span class="screen_out">KRW</span></td><td>105,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>99,000<span class="screen_out">KRW</span></td><td>141,000<span class="screen_out">KRW</span></td><td>215,000<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>100,500<span class="screen_out">KRW</span></td><td>143,500<span class="screen_out">KRW</span></td><td>219,500<span class="screen_out">KRW</span></td><td>110,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>102,000<span class="screen_out">KRW</span></td><td>146,500<span class="screen_out">KRW</span></td><td>224,000<span class="screen_out">KRW</span></td><td>112,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>103,500<span class="screen_out">KRW</span></td><td>149,500<span class="screen_out">KRW</span></td><td>228,500<span class="screen_out">KRW</span></td><td>114,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>105,000<span class="screen_out">KRW</span></td><td>152,500<span class="screen_out">KRW</span></td><td>232,500<span class="screen_out">KRW</span></td><td>116,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>106,500<span class="screen_out">KRW</span></td><td>155,000<span class="screen_out">KRW</span></td><td>237,000<span class="screen_out">KRW</span></td><td>118,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>108,000<span class="screen_out">KRW</span></td><td>158,000<span class="screen_out">KRW</span></td><td>241,500<span class="screen_out">KRW</span></td><td>120,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>109,500<span class="screen_out">KRW</span></td><td>161,000<span class="screen_out">KRW</span></td><td>246,000<span class="screen_out">KRW</span></td><td>122,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>111,000<span class="screen_out">KRW</span></td><td>164,000<span class="screen_out">KRW</span></td><td>250,000<span class="screen_out">KRW</span></td><td>124,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>112,500<span class="screen_out">KRW</span></td><td>167,000<span class="screen_out">KRW</span></td><td>254,500<span class="screen_out">KRW</span></td><td>126,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>114,000<span class="screen_out">KRW</span></td><td>169,500<span class="screen_out">KRW</span></td><td>259,000<span class="screen_out">KRW</span></td><td>129,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>115,500<span class="screen_out">KRW</span></td><td>172,500<span class="screen_out">KRW</span></td><td>263,000<span class="screen_out">KRW</span></td><td>131,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>117,000<span class="screen_out">KRW</span></td><td>175,500<span class="screen_out">KRW</span></td><td>267,500<span class="screen_out">KRW</span></td><td>133,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>118,500<span class="screen_out">KRW</span></td><td>178,500<span class="screen_out">KRW</span></td><td>272,000<span class="screen_out">KRW</span></td><td>135,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>120,000<span class="screen_out">KRW</span></td><td>181,000<span class="screen_out">KRW</span></td><td>276,500<span class="screen_out">KRW</span></td><td>137,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>121,500<span class="screen_out">KRW</span></td><td>184,000<span class="screen_out">KRW</span></td><td>280,500<span class="screen_out">KRW</span></td><td>139,500<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem3" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>

        <div id="tableItem4" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">Russia, Singapore, Spain, Taiwan Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">Russia</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Singapore</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Spain</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Taiwan</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>32,500<span class="screen_out">KRW</span></td><td>15,000<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td><td>17,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>35,500<span class="screen_out">KRW</span></td><td>16,500<span class="screen_out">KRW</span></td><td>30,500<span class="screen_out">KRW</span></td><td>18,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>38,500<span class="screen_out">KRW</span></td><td>18,000<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td><td>19,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>41,500<span class="screen_out">KRW</span></td><td>19,500<span class="screen_out">KRW</span></td><td>35,000<span class="screen_out">KRW</span></td><td>20,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>44,500<span class="screen_out">KRW</span></td><td>21,000<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td><td>21,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>48,000<span class="screen_out">KRW</span></td><td>22,500<span class="screen_out">KRW</span></td><td>39,500<span class="screen_out">KRW</span></td><td>21,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>51,000<span class="screen_out">KRW</span></td><td>24,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>22,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>56,000<span class="screen_out">KRW</span></td><td>26,000<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td><td>24,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>60,500<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td><td>49,500<span class="screen_out">KRW</span></td><td>25,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>65,500<span class="screen_out">KRW</span></td><td>30,500<span class="screen_out">KRW</span></td><td>53,500<span class="screen_out">KRW</span></td><td>27,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>70,500<span class="screen_out">KRW</span></td><td>33,000<span class="screen_out">KRW</span></td><td>57,500<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>75,500<span class="screen_out">KRW</span></td><td>35,500<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td><td>29,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>80,500<span class="screen_out">KRW</span></td><td>37,500<span class="screen_out">KRW</span></td><td>66,500<span class="screen_out">KRW</span></td><td>31,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>85,000<span class="screen_out">KRW</span></td><td>40,000<span class="screen_out">KRW</span></td><td>71,000<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>90,000<span class="screen_out">KRW</span></td><td>42,500<span class="screen_out">KRW</span></td><td>75,500<span class="screen_out">KRW</span></td><td>34,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>95,000<span class="screen_out">KRW</span></td><td>44,500<span class="screen_out">KRW</span></td><td>80,000<span class="screen_out">KRW</span></td><td>36,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>100,000<span class="screen_out">KRW</span></td><td>47,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td><td>37,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>104,500<span class="screen_out">KRW</span></td><td>49,500<span class="screen_out">KRW</span></td><td>88,500<span class="screen_out">KRW</span></td><td>39,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>109,500<span class="screen_out">KRW</span></td><td>51,500<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>114,500<span class="screen_out">KRW</span></td><td>54,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>43,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>119,500<span class="screen_out">KRW</span></td><td>56,500<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>124,500<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td><td>106,500<span class="screen_out">KRW</span></td><td>47,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>128,500<span class="screen_out">KRW</span></td><td>61,000<span class="screen_out">KRW</span></td><td>111,000<span class="screen_out">KRW</span></td><td>49,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>132,500<span class="screen_out">KRW</span></td><td>63,500<span class="screen_out">KRW</span></td><td>115,000<span class="screen_out">KRW</span></td><td>51,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>137,000<span class="screen_out">KRW</span></td><td>65,500<span class="screen_out">KRW</span></td><td>119,500<span class="screen_out">KRW</span></td><td>53,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>141,000<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td><td>124,000<span class="screen_out">KRW</span></td><td>54,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>145,000<span class="screen_out">KRW</span></td><td>70,500<span class="screen_out">KRW</span></td><td>128,500<span class="screen_out">KRW</span></td><td>56,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>149,500<span class="screen_out">KRW</span></td><td>72,500<span class="screen_out">KRW</span></td><td>133,000<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>153,500<span class="screen_out">KRW</span></td><td>75,000<span class="screen_out">KRW</span></td><td>137,500<span class="screen_out">KRW</span></td><td>60,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>157,500<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td><td>142,000<span class="screen_out">KRW</span></td><td>62,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>161,500<span class="screen_out">KRW</span></td><td>79,500<span class="screen_out">KRW</span></td><td>146,000<span class="screen_out">KRW</span></td><td>64,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>166,000<span class="screen_out">KRW</span></td><td>82,000<span class="screen_out">KRW</span></td><td>150,500<span class="screen_out">KRW</span></td><td>66,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>170,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td><td>155,000<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>174,000<span class="screen_out">KRW</span></td><td>86,500<span class="screen_out">KRW</span></td><td>159,500<span class="screen_out">KRW</span></td><td>70,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>178,500<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td><td>164,000<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>182,500<span class="screen_out">KRW</span></td><td>91,000<span class="screen_out">KRW</span></td><td>168,500<span class="screen_out">KRW</span></td><td>73,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>186,500<span class="screen_out">KRW</span></td><td>93,500<span class="screen_out">KRW</span></td><td>172,500<span class="screen_out">KRW</span></td><td>75,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>191,000<span class="screen_out">KRW</span></td><td>96,000<span class="screen_out">KRW</span></td><td>177,000<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>195,000<span class="screen_out">KRW</span></td><td>98,000<span class="screen_out">KRW</span></td><td>181,500<span class="screen_out">KRW</span></td><td>79,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>199,000<span class="screen_out">KRW</span></td><td>100,500<span class="screen_out">KRW</span></td><td>186,000<span class="screen_out">KRW</span></td><td>81,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>203,500<span class="screen_out">KRW</span></td><td>103,000<span class="screen_out">KRW</span></td><td>190,500<span class="screen_out">KRW</span></td><td>83,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>207,500<span class="screen_out">KRW</span></td><td>105,000<span class="screen_out">KRW</span></td><td>195,000<span class="screen_out">KRW</span></td><td>85,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>211,500<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td><td>199,500<span class="screen_out">KRW</span></td><td>87,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>215,500<span class="screen_out">KRW</span></td><td>110,000<span class="screen_out">KRW</span></td><td>203,500<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>220,000<span class="screen_out">KRW</span></td><td>112,000<span class="screen_out">KRW</span></td><td>208,000<span class="screen_out">KRW</span></td><td>91,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>224,000<span class="screen_out">KRW</span></td><td>114,500<span class="screen_out">KRW</span></td><td>212,500<span class="screen_out">KRW</span></td><td>92,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>228,000<span class="screen_out">KRW</span></td><td>117,000<span class="screen_out">KRW</span></td><td>217,000<span class="screen_out">KRW</span></td><td>94,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>232,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td><td>221,500<span class="screen_out">KRW</span></td><td>96,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>236,500<span class="screen_out">KRW</span></td><td>121,500<span class="screen_out">KRW</span></td><td>226,000<span class="screen_out">KRW</span></td><td>98,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>240,500<span class="screen_out">KRW</span></td><td>124,000<span class="screen_out">KRW</span></td><td>230,000<span class="screen_out">KRW</span></td><td>100,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>245,000<span class="screen_out">KRW</span></td><td>126,000<span class="screen_out">KRW</span></td><td>234,500<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>249,000<span class="screen_out">KRW</span></td><td>128,500<span class="screen_out">KRW</span></td><td>239,000<span class="screen_out">KRW</span></td><td>104,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>253,000<span class="screen_out">KRW</span></td><td>131,000<span class="screen_out">KRW</span></td><td>243,500<span class="screen_out">KRW</span></td><td>106,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>257,500<span class="screen_out">KRW</span></td><td>133,000<span class="screen_out">KRW</span></td><td>248,000<span class="screen_out">KRW</span></td><td>108,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>261,500<span class="screen_out">KRW</span></td><td>135,500<span class="screen_out">KRW</span></td><td>252,500<span class="screen_out">KRW</span></td><td>109,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>265,500<span class="screen_out">KRW</span></td><td>138,000<span class="screen_out">KRW</span></td><td>257,000<span class="screen_out">KRW</span></td><td>111,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>269,500<span class="screen_out">KRW</span></td><td>140,000<span class="screen_out">KRW</span></td><td>261,000<span class="screen_out">KRW</span></td><td>113,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>274,000<span class="screen_out">KRW</span></td><td>142,500<span class="screen_out">KRW</span></td><td>265,500<span class="screen_out">KRW</span></td><td>115,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>278,000<span class="screen_out">KRW</span></td><td>145,000<span class="screen_out">KRW</span></td><td>270,000<span class="screen_out">KRW</span></td><td>117,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>282,000<span class="screen_out">KRW</span></td><td>147,000<span class="screen_out">KRW</span></td><td>274,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>286,500<span class="screen_out">KRW</span></td><td>149,500<span class="screen_out">KRW</span></td><td>279,000<span class="screen_out">KRW</span></td><td>121,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>290,500<span class="screen_out">KRW</span></td><td>151,500<span class="screen_out">KRW</span></td><td>283,500<span class="screen_out">KRW</span></td><td>123,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>294,500<span class="screen_out">KRW</span></td><td>154,000<span class="screen_out">KRW</span></td><td>287,500<span class="screen_out">KRW</span></td><td>125,000<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem4" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
      </div>

      <div class="wrap_table">

        <div id="tableItem5" class="table_item item_type1">
          <table class="tbl_global">
            <caption class="ir_caption">Thailand, United Kingdom, United States, Vietnam Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">Thailand</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">United Kingdom</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Vietnam</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">-</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>18,500<span class="screen_out">KRW</span></td><td>33,000<span class="screen_out">KRW</span></td><td>17,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>20,000<span class="screen_out">KRW</span></td><td>35,000<span class="screen_out">KRW</span></td><td>18,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>21,000<span class="screen_out">KRW</span></td><td>37,000<span class="screen_out">KRW</span></td><td>19,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>22,000<span class="screen_out">KRW</span></td><td>39,000<span class="screen_out">KRW</span></td><td>20,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>23,000<span class="screen_out">KRW</span></td><td>41,000<span class="screen_out">KRW</span></td><td>21,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>24,000<span class="screen_out">KRW</span></td><td>42,500<span class="screen_out">KRW</span></td><td>21,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>25,000<span class="screen_out">KRW</span></td><td>44,500<span class="screen_out">KRW</span></td><td>22,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>27,000<span class="screen_out">KRW</span></td><td>48,000<span class="screen_out">KRW</span></td><td>24,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>29,000<span class="screen_out">KRW</span></td><td>51,500<span class="screen_out">KRW</span></td><td>25,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>31,000<span class="screen_out">KRW</span></td><td>55,000<span class="screen_out">KRW</span></td><td>27,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>33,000<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td><td>28,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>34,500<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td><td>29,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>36,500<span class="screen_out">KRW</span></td><td>65,500<span class="screen_out">KRW</span></td><td>31,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>38,500<span class="screen_out">KRW</span></td><td>68,500<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>40,500<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td><td>34,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>42,500<span class="screen_out">KRW</span></td><td>76,500<span class="screen_out">KRW</span></td><td>36,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>44,000<span class="screen_out">KRW</span></td><td>80,500<span class="screen_out">KRW</span></td><td>37,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>46,000<span class="screen_out">KRW</span></td><td>84,500<span class="screen_out">KRW</span></td><td>39,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>48,500<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td><td>41,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>51,000<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td><td>43,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>53,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>45,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>55,500<span class="screen_out">KRW</span></td><td>101,500<span class="screen_out">KRW</span></td><td>47,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>58,000<span class="screen_out">KRW</span></td><td>105,500<span class="screen_out">KRW</span></td><td>49,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>60,500<span class="screen_out">KRW</span></td><td>110,000<span class="screen_out">KRW</span></td><td>51,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>63,000<span class="screen_out">KRW</span></td><td>114,000<span class="screen_out">KRW</span></td><td>53,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>65,000<span class="screen_out">KRW</span></td><td>118,000<span class="screen_out">KRW</span></td><td>54,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>67,500<span class="screen_out">KRW</span></td><td>122,500<span class="screen_out">KRW</span></td><td>56,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>70,000<span class="screen_out">KRW</span></td><td>126,500<span class="screen_out">KRW</span></td><td>58,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>72,500<span class="screen_out">KRW</span></td><td>131,000<span class="screen_out">KRW</span></td><td>60,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>74,500<span class="screen_out">KRW</span></td><td>135,000<span class="screen_out">KRW</span></td><td>62,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>77,000<span class="screen_out">KRW</span></td><td>139,000<span class="screen_out">KRW</span></td><td>64,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>79,500<span class="screen_out">KRW</span></td><td>143,500<span class="screen_out">KRW</span></td><td>66,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>82,000<span class="screen_out">KRW</span></td><td>147,500<span class="screen_out">KRW</span></td><td>68,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>84,000<span class="screen_out">KRW</span></td><td>151,500<span class="screen_out">KRW</span></td><td>70,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>86,500<span class="screen_out">KRW</span></td><td>156,000<span class="screen_out">KRW</span></td><td>72,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>89,000<span class="screen_out">KRW</span></td><td>160,000<span class="screen_out">KRW</span></td><td>73,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>91,500<span class="screen_out">KRW</span></td><td>164,500<span class="screen_out">KRW</span></td><td>75,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>94,000<span class="screen_out">KRW</span></td><td>168,500<span class="screen_out">KRW</span></td><td>77,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>96,000<span class="screen_out">KRW</span></td><td>172,500<span class="screen_out">KRW</span></td><td>79,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>98,500<span class="screen_out">KRW</span></td><td>177,000<span class="screen_out">KRW</span></td><td>81,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>101,000<span class="screen_out">KRW</span></td><td>181,000<span class="screen_out">KRW</span></td><td>83,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>103,500<span class="screen_out">KRW</span></td><td>185,000<span class="screen_out">KRW</span></td><td>85,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>105,500<span class="screen_out">KRW</span></td><td>189,500<span class="screen_out">KRW</span></td><td>87,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>108,000<span class="screen_out">KRW</span></td><td>193,500<span class="screen_out">KRW</span></td><td>89,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>110,500<span class="screen_out">KRW</span></td><td>198,000<span class="screen_out">KRW</span></td><td>91,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>113,000<span class="screen_out">KRW</span></td><td>202,000<span class="screen_out">KRW</span></td><td>92,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>115,500<span class="screen_out">KRW</span></td><td>206,000<span class="screen_out">KRW</span></td><td>94,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>117,500<span class="screen_out">KRW</span></td><td>210,500<span class="screen_out">KRW</span></td><td>96,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>120,000<span class="screen_out">KRW</span></td><td>214,500<span class="screen_out">KRW</span></td><td>98,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>122,500<span class="screen_out">KRW</span></td><td>218,500<span class="screen_out">KRW</span></td><td>100,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>125,000<span class="screen_out">KRW</span></td><td>223,000<span class="screen_out">KRW</span></td><td>102,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>127,000<span class="screen_out">KRW</span></td><td>227,000<span class="screen_out">KRW</span></td><td>104,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>129,500<span class="screen_out">KRW</span></td><td>231,500<span class="screen_out">KRW</span></td><td>106,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>132,000<span class="screen_out">KRW</span></td><td>235,500<span class="screen_out">KRW</span></td><td>108,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>134,500<span class="screen_out">KRW</span></td><td>239,500<span class="screen_out">KRW</span></td><td>109,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>136,500<span class="screen_out">KRW</span></td><td>244,000<span class="screen_out">KRW</span></td><td>111,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>139,000<span class="screen_out">KRW</span></td><td>248,000<span class="screen_out">KRW</span></td><td>113,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>141,500<span class="screen_out">KRW</span></td><td>252,000<span class="screen_out">KRW</span></td><td>115,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>144,000<span class="screen_out">KRW</span></td><td>256,500<span class="screen_out">KRW</span></td><td>117,500<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>146,500<span class="screen_out">KRW</span></td><td>260,500<span class="screen_out">KRW</span></td><td>119,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>148,500<span class="screen_out">KRW</span></td><td>265,000<span class="screen_out">KRW</span></td><td>121,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>151,000<span class="screen_out">KRW</span></td><td>269,000<span class="screen_out">KRW</span></td><td>123,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>153,500<span class="screen_out">KRW</span></td><td>273,000<span class="screen_out">KRW</span></td><td>125,000<span class="screen_out">KRW</span></td><td>-<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem5" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>

        <div id="tableItem6" class="table_item item_type2">
          <table class="tbl_global">
            <caption class="ir_caption">Area 1,2,3,4 Shipping Fees</caption>
            <thead class="thead_global">
            <tr>
              <th class="col_type1" scope="col">Weight(Kg)</th>
              <th class="col_type2" scope="col"><span class="txt_region">Area 1</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Area 2</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Area 3</span></th>
              <th class="col_type2" scope="col"><span class="txt_region">Area 4</span></th>
            </tr>
            </thead>
            <tbody class="tbody_global">
            <tr>
              <th scope="row">0.5</th><td>20,500<span class="screen_out">KRW</span></td><td> 20,500<span class="screen_out">KRW</span></td><td>30,500<span class="screen_out">KRW</span></td><td>33,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">0.75</th><td>21,500<span class="screen_out">KRW</span></td><td> 22,000<span class="screen_out">KRW</span></td><td>32,500<span class="screen_out">KRW</span></td><td>36,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.0</th><td>22,500<span class="screen_out">KRW</span></td><td> 23,500<span class="screen_out">KRW</span></td><td>34,500<span class="screen_out">KRW</span></td><td>39,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.25</th><td>23,500<span class="screen_out">KRW</span></td><td> 25,000<span class="screen_out">KRW</span></td><td>36,500<span class="screen_out">KRW</span></td><td>42,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.5</th><td>24,500<span class="screen_out">KRW</span></td><td> 26,500<span class="screen_out">KRW</span></td><td>38,500<span class="screen_out">KRW</span></td><td>45,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">1.75</th><td>25,500<span class="screen_out">KRW</span></td><td> 28,000<span class="screen_out">KRW</span></td><td>40,500<span class="screen_out">KRW</span></td><td>48,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.0</th><td>26,500<span class="screen_out">KRW</span></td><td> 29,500<span class="screen_out">KRW</span></td><td>42,500<span class="screen_out">KRW</span></td><td>51,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">2.5</th><td>28,500<span class="screen_out">KRW</span></td><td> 32,000<span class="screen_out">KRW</span></td><td>46,500<span class="screen_out">KRW</span></td><td>56,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.0</th><td>30,500<span class="screen_out">KRW</span></td><td> 35,000<span class="screen_out">KRW</span></td><td>50,000<span class="screen_out">KRW</span></td><td>62,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">3.5</th><td>32,000<span class="screen_out">KRW</span></td><td> 37,500<span class="screen_out">KRW</span></td><td>54,000<span class="screen_out">KRW</span></td><td>69,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.0</th><td>34,000<span class="screen_out">KRW</span></td><td> 40,500<span class="screen_out">KRW</span></td><td>58,000<span class="screen_out">KRW</span></td><td>77,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">4.5</th><td>36,000<span class="screen_out">KRW</span></td><td> 43,000<span class="screen_out">KRW</span></td><td>61,500<span class="screen_out">KRW</span></td><td>85,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.0</th><td>38,000<span class="screen_out">KRW</span></td><td> 46,000<span class="screen_out">KRW</span></td><td>65,500<span class="screen_out">KRW</span></td><td>92,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">5.5</th><td>39,500<span class="screen_out">KRW</span></td><td> 48,500<span class="screen_out">KRW</span></td><td>69,000<span class="screen_out">KRW</span></td><td>100,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.0</th><td>41,500<span class="screen_out">KRW</span></td><td> 51,000<span class="screen_out">KRW</span></td><td>73,000<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">6.5</th><td>43,500<span class="screen_out">KRW</span></td><td> 54,000<span class="screen_out">KRW</span></td><td>78,000<span class="screen_out">KRW</span></td><td>115,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.0</th><td>45,500<span class="screen_out">KRW</span></td><td> 56,500<span class="screen_out">KRW</span></td><td>83,000<span class="screen_out">KRW</span></td><td>123,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">7.5</th><td>48,000<span class="screen_out">KRW</span></td><td> 59,500<span class="screen_out">KRW</span></td><td>88,000<span class="screen_out">KRW</span></td><td>130,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.0</th><td>50,500<span class="screen_out">KRW</span></td><td> 61,000<span class="screen_out">KRW</span></td><td>93,000<span class="screen_out">KRW</span></td><td>138,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">8.5</th><td>52,500<span class="screen_out">KRW</span></td><td> 66,000<span class="screen_out">KRW</span></td><td>97,500<span class="screen_out">KRW</span></td><td>145,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.0</th><td>55,000<span class="screen_out">KRW</span></td><td> 70,500<span class="screen_out">KRW</span></td><td>102,500<span class="screen_out">KRW</span></td><td>153,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">9.5</th><td>57,500<span class="screen_out">KRW</span></td><td> 75,500<span class="screen_out">KRW</span></td><td>107,500<span class="screen_out">KRW</span></td><td>160,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.0</th><td>60,000<span class="screen_out">KRW</span></td><td> 80,500<span class="screen_out">KRW</span></td><td>112,500<span class="screen_out">KRW</span></td><td>168,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">10.5</th><td>62,000<span class="screen_out">KRW</span></td><td> 85,000<span class="screen_out">KRW</span></td><td>117,500<span class="screen_out">KRW</span></td><td>176,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.0</th><td>64,500<span class="screen_out">KRW</span></td><td> 90,000<span class="screen_out">KRW</span></td><td>122,500<span class="screen_out">KRW</span></td><td>183,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">11.5</th><td>67,000<span class="screen_out">KRW</span></td><td> 95,000<span class="screen_out">KRW</span></td><td>127,500<span class="screen_out">KRW</span></td><td>191,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.0</th><td>69,000<span class="screen_out">KRW</span></td><td> 99,500<span class="screen_out">KRW</span></td><td>132,500<span class="screen_out">KRW</span></td><td>198,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">12.5</th><td>71,500<span class="screen_out">KRW</span></td><td> 104,500<span class="screen_out">KRW</span></td><td>137,500<span class="screen_out">KRW</span></td><td>206,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.0</th><td>74,000<span class="screen_out">KRW</span></td><td> 109,000<span class="screen_out">KRW</span></td><td>142,500<span class="screen_out">KRW</span></td><td>214,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">13.5</th><td>76,000<span class="screen_out">KRW</span></td><td> 114,000<span class="screen_out">KRW</span></td><td>147,500<span class="screen_out">KRW</span></td><td>221,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.0</th><td>78,500<span class="screen_out">KRW</span></td><td> 119,000<span class="screen_out">KRW</span></td><td>152,500<span class="screen_out">KRW</span></td><td>229,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">14.5</th><td>81,000<span class="screen_out">KRW</span></td><td> 123,500<span class="screen_out">KRW</span></td><td>157,500<span class="screen_out">KRW</span></td><td>236,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.0</th><td>83,000<span class="screen_out">KRW</span></td><td> 128,500<span class="screen_out">KRW</span></td><td>162,000<span class="screen_out">KRW</span></td><td>244,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">15.5</th><td>85,500<span class="screen_out">KRW</span></td><td> 133,500<span class="screen_out">KRW</span></td><td>167,000<span class="screen_out">KRW</span></td><td>252,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.0</th><td>88,000<span class="screen_out">KRW</span></td><td> 138,000<span class="screen_out">KRW</span></td><td>172,000<span class="screen_out">KRW</span></td><td>259,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">16.5</th><td>90,000<span class="screen_out">KRW</span></td><td> 143,000<span class="screen_out">KRW</span></td><td>177,000<span class="screen_out">KRW</span></td><td>267,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.0</th><td>92,500<span class="screen_out">KRW</span></td><td> 148,000<span class="screen_out">KRW</span></td><td>182,000<span class="screen_out">KRW</span></td><td>274,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">17.5</th><td>95,000<span class="screen_out">KRW</span></td><td> 152,500<span class="screen_out">KRW</span></td><td>187,000<span class="screen_out">KRW</span></td><td>282,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.0</th><td>97,000<span class="screen_out">KRW</span></td><td> 157,500<span class="screen_out">KRW</span></td><td>192,000<span class="screen_out">KRW</span></td><td>289,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">18.5</th><td>99,500<span class="screen_out">KRW</span></td><td> 162,000<span class="screen_out">KRW</span></td><td>197,000<span class="screen_out">KRW</span></td><td>297,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.0</th><td>102,000<span class="screen_out">KRW</span></td><td> 167,000<span class="screen_out">KRW</span></td><td>202,000<span class="screen_out">KRW</span></td><td>305,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">19.5</th><td>104,500<span class="screen_out">KRW</span></td><td> 172,000<span class="screen_out">KRW</span></td><td>207,000<span class="screen_out">KRW</span></td><td>312,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.0</th><td>106,500<span class="screen_out">KRW</span></td><td> 176,500<span class="screen_out">KRW</span></td><td>212,000<span class="screen_out">KRW</span></td><td>320,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">20.5</th><td>109,000<span class="screen_out">KRW</span></td><td> 181,500<span class="screen_out">KRW</span></td><td>217,000<span class="screen_out">KRW</span></td><td>327,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.0</th><td>111,500<span class="screen_out">KRW</span></td><td> 186,500<span class="screen_out">KRW</span></td><td>221,500<span class="screen_out">KRW</span></td><td>335,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">21.5</th><td>113,500<span class="screen_out">KRW</span></td><td> 191,000<span class="screen_out">KRW</span></td><td>226,500<span class="screen_out">KRW</span></td><td>343,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.0</th><td>116,000<span class="screen_out">KRW</span></td><td> 196,000<span class="screen_out">KRW</span></td><td>231,500<span class="screen_out">KRW</span></td><td>350,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">22.5</th><td>118,500<span class="screen_out">KRW</span></td><td> 200,500<span class="screen_out">KRW</span></td><td>236,500<span class="screen_out">KRW</span></td><td>358,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.0</th><td>120,500<span class="screen_out">KRW</span></td><td> 205,500<span class="screen_out">KRW</span></td><td>241,500<span class="screen_out">KRW</span></td><td>365,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">23.5</th><td>123,000<span class="screen_out">KRW</span></td><td> 210,500<span class="screen_out">KRW</span></td><td>246,500<span class="screen_out">KRW</span></td><td>373,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.0</th><td>125,500<span class="screen_out">KRW</span></td><td> 215,000<span class="screen_out">KRW</span></td><td>251,500<span class="screen_out">KRW</span></td><td>381,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">24.5</th><td>127,500<span class="screen_out">KRW</span></td><td> 220,000<span class="screen_out">KRW</span></td><td>256,500<span class="screen_out">KRW</span></td><td>388,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.0</th><td>130,000<span class="screen_out">KRW</span></td><td> 225,000<span class="screen_out">KRW</span></td><td>261,500<span class="screen_out">KRW</span></td><td>396,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">25.5</th><td>132,500<span class="screen_out">KRW</span></td><td> 229,500<span class="screen_out">KRW</span></td><td>266,500<span class="screen_out">KRW</span></td><td>403,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.0</th><td>134,500<span class="screen_out">KRW</span></td><td> 234,500<span class="screen_out">KRW</span></td><td>271,500<span class="screen_out">KRW</span></td><td>411,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">26.5</th><td>137,000<span class="screen_out">KRW</span></td><td> 239,500<span class="screen_out">KRW</span></td><td>276,500<span class="screen_out">KRW</span></td><td>418,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.0</th><td>139,500<span class="screen_out">KRW</span></td><td> 244,000<span class="screen_out">KRW</span></td><td>281,500<span class="screen_out">KRW</span></td><td>426,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">27.5</th><td>141,500<span class="screen_out">KRW</span></td><td> 249,000<span class="screen_out">KRW</span></td><td>286,000<span class="screen_out">KRW</span></td><td>434,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.0</th><td>144,000<span class="screen_out">KRW</span></td><td> 253,500<span class="screen_out">KRW</span></td><td>291,000<span class="screen_out">KRW</span></td><td>441,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">28.5</th><td>146,500<span class="screen_out">KRW</span></td><td> 258,500<span class="screen_out">KRW</span></td><td>296,000<span class="screen_out">KRW</span></td><td>449,000<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.0</th><td>149,000<span class="screen_out">KRW</span></td><td> 263,500<span class="screen_out">KRW</span></td><td>301,000<span class="screen_out">KRW</span></td><td>456,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">29.5</th><td>151,000<span class="screen_out">KRW</span></td><td> 268,000<span class="screen_out">KRW</span></td><td>306,000<span class="screen_out">KRW</span></td><td>464,500<span class="screen_out">KRW</span></td>
            </tr>
            <tr>
              <th scope="row">30.0</th><td>153,500<span class="screen_out">KRW</span></td><td> 273,000<span class="screen_out">KRW</span></td><td>311,000<span class="screen_out">KRW</span></td><td>472,000<span class="screen_out">KRW</span></td>
            </tr>
            </tbody>
          </table>
          <a href="#tableItem6" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
        </div>
        <a href="#none" class="btn_view"><span class="ico_friends ico_arr">open</span></a>
      </div>
    </div>
  </div>

  <div id="tabInfo5" class="tab_cont">
    <h3 class="screen_out">Deliver To</h3>
    <div class="cont_subject cont_country">
      <h4 class="tit_country">Asia - Pacific / the Middle East / Africa</h4><!-- 2017-06-14 수정 -->
      <ul class="list_country">
        <li><span class="img_flag flag_aus"></span>Australia</li>
        <li><span class="img_flag flag_bru"></span>Brunei</li>
        <li><span class="img_flag flag_chn"></span>China</li>
        <li><span class="img_flag flag_hkg"></span>Hong Kong</li>
        <li><span class="img_flag flag_ind"></span>India</li>
        <li><span class="img_flag flag_ina"></span>Indonesia</li>
        <li><span class="img_flag flag_isr"></span>Israel</li>
        <li><span class="img_flag flag_jpn"></span>Japan</li>
        <li><span class="img_flag flag_ken"></span>kenya</li>
        <li><span class="img_flag flag_lao"></span>Laos</li>
        <li><span class="img_flag flag_mac"></span>Macau</li>
        <li><span class="img_flag flag_mas"></span>Malaysia</li>
        <li><span class="img_flag flag_mar"></span>Morocco</li>
        <li><span class="img_flag flag_mya"></span>Myanmar</li>
        <li><span class="img_flag flag_nzl"></span>New Zealand</li>
        <li><span class="img_flag flag_phi"></span>Philippines</li>
        <li><span class="img_flag flag_qat"></span>Qatar</li>
        <li><span class="img_flag flag_ksa"></span>Saudi Arabia</li>
        <li><span class="img_flag flag_sin"></span>Singapore</li>
        <li><span class="img_flag flag_twn"></span>Taiwan</li>
        <li><span class="img_flag flag_tha"></span>Thailand</li>
        <li><span class="img_flag flag_uae"></span>UAE</li>
        <li><span class="img_flag flag_uzb"></span>Uzbekistan</li>
        <li><span class="img_flag flag_vie"></span>Vietnam</li>
      </ul>
      <h4 class="tit_country">Europe</h4>
      <ul class="list_country">
        <li><span class="img_flag flag_aut"></span>Austria</li>
        <li><span class="img_flag flag_bel"></span>Belgium</li>
        <li><span class="img_flag flag_cro"></span>Croatia</li>
        <li><span class="img_flag flag_cze"></span>Czech</li>
        <li><span class="img_flag flag_den"></span>Denmark</li>
        <li><span class="img_flag flag_fin"></span>Finland</li>
        <%--<li><span class="img_flag flag_fra"></span>France</li>--%>
        <li><span class="img_flag flag_ger"></span>Germany</li>
        <li><span class="img_flag flag_irl"></span>Ireland</li>
        <li><span class="img_flag flag_ned"></span>Netherlands</li>
        <li><span class="img_flag flag_nor"></span>Norway</li>
        <li><span class="img_flag flag_pol"></span>Poland</li>
        <li><span class="img_flag flag_por"></span>Portugal</li>
        <li><span class="img_flag flag_rou"></span>Romania</li>
        <li><span class="img_flag flag_rus"></span>Russia</li>
        <li><span class="img_flag flag_svk"></span>Slovakia</li>
        <li><span class="img_flag flag_esp"></span>Spain</li>
        <li><span class="img_flag flag_swe"></span>Sweden</li>
        <li><span class="img_flag flag_sui"></span>Switzerland</li>
        <li><span class="img_flag flag_tur"></span>Turkey</li>
        <li><span class="img_flag flag_gbr"></span>United Kingdom</li>
      </ul>
      <h4 class="tit_country">North America / Latin America</h4>
      <ul class="list_country">
        <li><span class="img_flag flag_arg"></span>Argentina</li>
        <li><span class="img_flag flag_bra"></span>Brazil</li>
        <%--<li><span class="img_flag flag_can"></span>Canada</li>--%>
        <li><span class="img_flag flag_chi"></span>Chile</li>
        <li><span class="img_flag flag_per"></span>Peru</li>
        <li><span class="img_flag flag_mex"></span>Mexico</li>
        <li><span class="img_flag flag_usa"></span>United States</li>
      </ul>
      <strong class="tit_item">Important considerations for each country</strong>
      <p class="desc_notice">For a list of banned or restricted items in each country, please refer to the customs information for the country in question, below.</p>
      <a href="http://ems.epost.go.kr/front.EmsSurveySurvey01.postal" class="btn_notice" target="_blank">Customs information by country</a>
    </div>
  </div>
</div>