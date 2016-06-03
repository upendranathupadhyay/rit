<!DOCTYPE html>
<html>
	<body onload="hide();" bgcolor="BurlyWood">
	<script>
	 function show1() { 
		 hide();
		 document.getElementById('box1').style.display = 'block';
		 
	 }
	 function show3() { 
		 hide();
		 document.getElementById('box2').style.display = 'block';
		 
	 }
     function hide() { 
    	 document.getElementById('box1').style.display = 'none';
    	 document.getElementById('box2').style.display = 'none';
     }
     function show2() {
    	 hide();
    	 document.getElementById('box1').style.display = 'block'; 
     	 document.getElementById('box2').style.display = 'block'; 
     }
	</script>
		<h2 align="center">Search Employee Based On Filter</h2>
		<form method="post" action="ShowResult">
		<center>
			<table cellpadding="1">
				<tr>
					<td>
						<input type="radio" name="id" value="ID" onclick="show1();" />ID<br>
		       		</td> 
		       	</tr>
		        <tr> 
		        	 <td>
		        	    <input type="radio" name="id" value="Name" onclick="show3();" />Name<br>
		       		</td> 
		       	</tr>   
		        <tr> 
		        	<td>
		       		     <input type="radio" name="id" value="Both Name And ID" onclick="show2();"/>Both Name and ID
		       		</td>
		  	    </tr>
		        <tr>
		           <td>
		            	<input type="radio" name="id" value="All" onclick="hide();" checked="checked"/>All<br><br>
		           </td> 
		        </tr>
		        	   
		         <tr> 
		         	 <td>
		         		 <input type="text" name="text1" id="box1" placeholder="Enter ID">
		         	 </td>  
		         </tr>
		         <tr>	
		         	<td>
		           		 <input type="text" name="text2" id="box2" placeholder="Enter Name"><br>
		         	</td> 
		        </tr>
		        <tr>  
		        	 <td>
		           		 <input type="submit" name="click" value="Submit" />
		        	 </td> 
		         </tr> 
            </table>
          </center>
         </form>   

	</body>
</html>