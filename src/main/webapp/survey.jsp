<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey</title>
<%@include file="includes.jsp"%>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.8/jquery.validate.min.js"></script>
<script type="text/javascript"> $(document).ready(function(){ $("#subForm").validate(); }); </script>
<script src="http://jquery.bassistance.de/validate/additional-methods.js"></script>

<script type="text/javascript">
$(document).ready(function () {
   
   $('#submit').click(function(event) {
	   
	   var q1 = $('input:radio[name=Q1]:checked').val();
	   //alert(q1);
	   var q2 = $('input:radio[name=Q2]:checked').val();
	   var mylist = $('#mylist').val();
	  // alert(mylist.length);
	   var q4 = $('input:radio[name=Q4]:checked').val();
	  // alert("q4 is" + q4);
	   var q5 = $('input:radio[name=Q5]:checked').val();
	  // alert("q5 is" + q5);
	   var q6 = $('input:radio[name=Q6]:checked').val();
	  // alert("q6 is" + q6);
	   var q7 = $('input:radio[name=Q7]:checked').val();
	  //alert("q7 is" + q7);
	   var q8 = $('input:radio[name=Q8]:checked').val();
	  // alert("q8 is" + q8);
	   var q9 = $('input:radio[name=Q9]:checked').val();
	 //  alert("q9 is" + q9);
	   var q10 = $('input:radio[name=Q10]:checked').val();
	  // alert("q10 is" + q10);
	   //+ "&q7=" + q7 + "&q8=" + q8 + "&q9=" + q9 + "&q10=" + q10
	   //var d = "q1=" + q1 + "&q2=" + q2 + "&county=" + county + "&q4=" + q4 + "&q5=" + q5 + "&q6=" + q6 + "&q7=" + q7 + "&q8=" + q8 + "&q9=" + q9 + "&q10=" + q10;
	   var s = q1 + "," + q2 + "," + mylist + "," + q4 + "," + q5 + "," + q6 + 
	   			"," + q7 + "," + q8 + "," + q9 + "," + q10;
	   var d = "Rohit";
	  // alert(s);
	  // alert(d);
	   
	   s = s.replace(/[$]/g,'zzz');
	   s = s.replace(/[-]/g,'yyy');
	   s = s.replace(/[/]/g,'qqq');
	   s = s.replace(/[%]/g,'ppp');
	   
	   /*  s = s.replace('/\$/g', 'zzz');
	    s = s.replace('/\-/g', 'yyy');
	   s = s.replace('/\//g', 'qqq');
	   s = s.replace('/\%/g', 'ppp'); */
 
	   //alert("value after replace:" + s);
	   
	   $.ajax({
			url : "rest/MainController/reco",
		    type: "POST",
		    data : "s=" + s,
		    success:function(data, textStatus, jqXHR){
		    	//alert("success");
		    	window.location.href="home.jsp";
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert("Could not process request.. " + errorThrown);
		    }
		});
   });
});
</script>

<body bgcolor="PowderBlue">
<%@include file="header.jsp"%>

<div align="center">
<h3>Please complete the following Questionnaire</h3>
<table>

		<tr>
		<td><label>Q1. Please specify the range of your age: </label></td></tr>
		<tr><td><input type="radio" name = "Q1" value = "1-14"/>1-14</td></tr>
		<tr><td><input type="radio" name = "Q1" value = "15-24"/>15-24</td></tr>
		<tr><td><input type="radio" name = "Q1" value = "25-44"/>25-44</td></tr>
		<tr><td><input type="radio" name = "Q1" value = "45-64"/>45-64</td></tr>
		<tr><td><input type="radio" name = "Q1" value = "65+"/>65+</td>
		</tr>

		<tr><td><label>Q2. Please specify your race:</label></td></tr>
		<tr><td><input type="radio" name = "Q2" value = " White"/> White</td></tr>
		<tr><td><input type="radio" name = "Q2" value = "Black"/>Black</td></tr>
		<tr><td><input type="radio" name = "Q2" value = "Hispanic"/>Hispanic</td></tr>
		<tr><td><input type="radio" name = "Q2" value = "Other"/>Other</td></tr>

		<tr><td><label>Q3. Please choose the county of your address:</label></td></tr>
		<tr><td><select id="mylist" name = "mylist" ><option value="Alameda">Alameda</option><option value="Alpine">Alpine</option>
		<option value="Amador">Amador</option>
		<option value="Butte">Butte</option>
		<option value="Calaveras">Calaveras</option>
		<option value="Colusa">Colusa</option>
		<option value="Contra Costa">Contra Costa</option>
		<option value="Del Norte">Del Norte</option>
		<option value="El Dorado">El Dorado</option>
		<option value="Fresno">Fresno</option>
		<option value="Glenn">Glenn</option>
		<option value="Humboldt">Humboldt</option>
		<option value="Imperial">Imperial</option>
		<option value="Inyo">Inyo</option>
		<option value="Kern">Kern</option>
		<option value="Kings">Kings</option>
		<option value="Lake">Lake</option>
		<option value="Lassen">Lassen</option>
		<option value="Los Angeles">Los Angeles</option>
		<option value="Madera">Madera</option>
		<option value="Marin">Marin</option>
		<option value="Mariposa">Mariposa</option>
		<option value="Mendocino">Mendocino</option>
		<option value="Merced">Merced</option>
		<option value="Modoc">Modoc</option>
		<option value="Mono">Mono</option>
		<option value="Napa">Napa</option>
		<option value="Monterey">Monterey</option>
		<option value="Nevada">Nevada</option>
		<option value="Orange">Orange</option>
		<option value="Placer">Placer</option>
		<option value="Plumas">Plumas</option>
		<option value="Riverside">Riverside</option>
		<option value="Sacramento">Sacramento</option>
		<option value="San Benito">San Benito</option>
		<option value="San Bernardino">San Bernardino</option>
		<option value="San Diego">San Diego</option>
		<option value="San Francisco">San Francisco</option>
		<option value="San Joaquin">San Joaquin</option>
		<option value="San Luis Obispo">San Luis Obispo</option>
		<option value="San Mateo">San Mateo</option>
		<option value="Santa Barbara">Santa Barbara</option>
		<option value="Santa Clara">Santa Clara</option>
		<option value="Santa Cruz">Santa Cruz</option>
		<option value="Shasta">Shasta</option>
		<option value="Sierra">Sierra</option>
		<option value="Siskiyou">Siskiyou</option>
		<option value="Solano">Solano</option>
		<option value="Sonoma">Sonoma</option>
		<option value="Stanislaus">Stanislaus</option>
		<option value="Sutter">Sutter</option>
		<option value="Tehama">Tehama</option>
		<option value="Trinity">Trinity</option>
		<option value="Tulare">Tulare</option>
		<option value="Tuolumne">Tuolumne</option>
		<option value="Ventura">Ventura</option>
		<option value="Yolo">Yolo</option>
		<option value="Yuba">Yuba</option>
		</select></td></tr>

		<tr><td><label>Q4. Please specify the range of your income:</label></td></tr>
		<tr><td><input type="radio" name = "Q4" value = "Less than $ 30k/annum"/>Less than $ 30k/annum</td></tr>
		<tr><td><input type="radio" name = "Q4" value = "Between $30k/annum - $50k/annum"/>Between $30k/annum - $50k/annum</td></tr>
		<tr><td><input type="radio" name = "Q4" value = "Between $50k/annum - $80k/annum"/>Between $50k/annum - $80k/annum</td></tr>
		<tr><td><input type="radio" name = "Q4" value = "More than $ 80k/annum"/>More than $ 80k/annum</td></tr>

		<tr><td><label>Q5. Please specify the range of your weight:</label></td></tr>
		<tr><td><input type="radio" name = "Q5" value = "Less than 60 kg"/>Less than 60 kg</td></tr>
		<tr><td><input type="radio" name = "Q5" value = "Between 60kg - 80kg"/>Between 60kg - 80kg</td></tr>
		<tr><td><input type="radio" name = "Q5" value = "Between 80kg - 100kg"/>Between 80kg - 100kg</td></tr>
		<tr><td><input type="radio" name = "Q5" value = "More than 100kg"/>More than 100kg</td></tr>

		<tr><td><label>Q6. Have you passed High school Diploma:</label></td></tr>
		<tr><td><input type="radio" name = "Q6" value = "Yes"/>Yes</td></tr>
		<tr><td><input type="radio" name = "Q6" value = "No"/>No</td></tr>

		<tr><td><label>Q7. How many days a week do you exercise:</label></td></tr>
		<tr><td><input type="radio" name = "Q7" value = "All 7 days"/>All 7 days</td></tr>
		<tr><td><input type="radio" name = "Q7" value = "Between 4 - 6 days"/>Between 4 - 6 days</td></tr>
		<tr><td><input type="radio" name = "Q7" value = "Between 2 - 4 days"/>Between 2 - 4 days</td></tr>
		<tr><td><input type="radio" name = "Q7" value = "Never"/>Never</td></tr>

		<tr><td><label>Q8. In what percentage do you eat healthy food/ fruits:</label></td></tr>
		<tr><td><input type="radio" name = "Q8" value = "Between 75 % - 100 %"/>Between 75 % - 100 %</td></tr>
		<tr><td><input type="radio" name = "Q8" value = "Between 50 % - 75%"/>Between 50 % - 75%</td></tr>
		<tr><td><input type="radio" name = "Q8" value = "Between 25% - 50%"/>Between 25% - 50%</td></tr>
		<tr><td><input type="radio" name = "Q8" value = "Less than 25%"/>Less than 25%</td></tr>

		<tr><td><label>Q9. How often do you smoke or drink:</label></td></tr>
		<tr><td><input type="radio" name = "Q9" value = "Between 75 % - 100 %"/>Between 75 % - 100 %</td></tr>
		<tr><td><input type="radio" name = "Q9" value = "Between 50 % - 75%"/>Between 50 % - 75%</td></tr>
		<tr><td><input type="radio" name = "Q9" value = "Between 25% - 50%"/>Between 25% - 50%</td></tr>
		<tr><td><input type="radio" name = "Q9" value = "Less than 25%"/>Less than 25%</td></tr>


		<tr><td><label>Q10. Do you have health Insurance:</label></td></tr>
		<tr><td><input type="radio" name = "Q10" value = "Yes"/>Yes</td></tr>
		<tr><td><input type="radio" name = "Q10" value = "No"/>No</td></tr>

	</table>

<br>	<input type="submit" class="btn btn-primary" id="submit" value="Submit your answers"/></div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



<%@include file="footer.jsp"%>
</body>
</html>