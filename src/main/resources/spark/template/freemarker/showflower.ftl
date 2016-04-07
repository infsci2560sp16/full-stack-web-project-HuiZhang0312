<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>
  <div id="header">
   <ul>
     <li class="selected"><a href="index.html">home</a></li>
     <li><a href="flowers.html">flowers</a></li>
     <li><a href="search.html">search</a></li>
     <li><a href="login.html">login</a></li>
     <li><a href="register.html">register</a></li>
   </ul>
   <div class="logo">
     <a href="index.html"><img src="images/orchid_logo.jpg" alt=""></a>
   </div>
   <div>
     <h3><a href="#"><br/>Today is ${dayOfWeek}</a></h3>

        <#if dayOfWeek == "Monday"|| dayOfWeek == "Wednesday"|| dayOfWeek == "Friday"||dayOfWeek == "Tuesday"|| dayOfWeek == "Thursday">

        <#list 0..weekday?size-1 as i>
        <h4>${weekday[i]}</h4>
        </#list>

        <#else>
        <#list 0..weekend?size-1 as i>
        <h4>${weekend[i]}</h4>
        </#list>

        </#if>
   </div>
 </div>
 <div id="body">
   <div class="featured">
     <div>
       <ul>
         <li><a href="index.html"><img src="images/backyard.jpg" alt=""></a></li>
         <li><a href="index.html"><img src="images/garden.jpg" alt=""></a></li>
       </ul>
       <div class="section">
         <div>
           <a href="index.html"><img src="images/bridal-bouquet.jpg" alt=""></a>
         </div>
       </div>
     </div>
   </div>
   <div class="content">
     <span class="heading"><img src="images/special-occasions-flowers.gif" alt=""></span>
     <div>
       <div>
         <ul>
           <li>
             <a href="flowers.html">
             <img src="images/tulips.jpg" alt="">
             <span>Tulips</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/bouquet.jpg" alt="">
             <span>Bouquet</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/roses.jpg" alt="">
             <span>Roses</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/bouquet2.jpg" alt="">
             <span>Bouquet</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/roses2.jpg" alt="">
             <span>Roses</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/bridal-bouquet2.jpg" alt="">
             <span>Bridal Bouquet</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/sunflower.jpg" alt="">
             <span>Sunflower</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/bouquet3.jpg" alt="">
             <span>Bouquet</span>
             </a>
           </li>
           <li>
             <a href="flowers.html">
             <img src="images/speedwell.jpg" alt="">
             <span>Speedwell</span>
             </a>
           </li>
         </ul>
         <h4><a href="flowers.html">view all flowers</a></h4>
       </div>
       <ul>
         <li>
           <h3>Show Flowers(Get JSON)</h3>
           <input type="button" value="GetJson" onclick="getJson()">
           <div class="flowers"></div>
         </li>
         <li>
           <h3>Second title two</h3>
           <p>Here is content two.</p>
         </li>
       </ul>
     </div>
   </div>
 </div>
 <div id="footer">
   <div>
     <div class="connect">
       <h4>Follow us:</h4>
       <ul>
         <li class="facebook"><a href="http://facebook.com/freewebsitetemplates" target="_blank">facebook</a></li>
         <li class="twitter"><a href="http://twitter.com/fwtemplates" target="_blank">twitter</a></li>
       </ul>
     </div>
     <p>Copyright &copy; 2015. All rights reserved.</p>
   </div>
 </div>


</body>
</html>
