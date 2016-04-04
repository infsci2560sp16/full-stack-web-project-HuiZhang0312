function getJson(){
  $.ajax({
    url : "/flowers",
    success : function(result) {
      var flowers = JSON.parse(result);
      for ( var i = 0; i < flowers.length; i++) {
        $("div.flowers").append(
          '<p class="question" id="' + flowers[i].id + '">' + flowers[i].name + '</p>' + '<br/>'
        );
      }
    }
  });
}
function getXml(){
    $.ajax({
         url : "/about",
         type : "get",
         success : function(result) {
           branch = result.getElementsByTagName("Branch");
           $("div.about").append(
               '<p>Name:'+branch[0].childNodes[0].firstChild.nodeValue+'</p>'+
               '<p>Profession:'+branch[0].childNodes[1].firstChild.nodeValue+'</p>'+
               '<p>Since:'+branch[0].childNodes[2].firstChild.nodeValue+'</p>'+
               '<p>Country:'+branch[0].childNodes[3].firstChild.nodeValue+'</p>'+
               '<p>State:'+branch[0].childNodes[4].firstChild.nodeValue+'</p>'+
               '<p>City:'+branch[0].childNodes[5].firstChild.nodeValue+'</p>'+
               '<p>OpenHour:'+branch[0].childNodes[6].firstChild.nodeValue+'</p>'+
               '<p>Phone:'+branch[0].childNodes[7].firstChild.nodeValue+'</p>'+
               '<p>Email:'+branch[0].childNodes[8].firstChild.nodeValue+'</p>'+
               '<p>Address:'+branch[0].childNodes[9].firstChild.nodeValue+'</p>'
             );
           }
         });
       }
function postJson(){
  var username = $("#username").val();
  var password = $("#password").val();
  var info = JSON.stringify({"username":username,"password":password});
  alert(info);
  $.ajax({
    contentType:'application/json',
    url : "/login",
    type : "post",
    dataType: "json",
    data:info,
    success : function(flowers){
      for ( var i = 0; i < flowers.length; i++) {
        $("div.flowers").append(
          '<p class="question" id="' + flowers[i].id + '">' + flowers[i].name + '</p>' + '<br/>'
        );
      }
      alert("Login successfully.");
      window.location.href='/index.html';
    }
  });
}
