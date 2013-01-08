<?php
include "db.php";
$login=$_COOKIE['login'];
$pass=$_COOKIE['pass'];
if($login and $pass){
    $user=mysql_fetch_array(mysql_query("SELECT * FROM users WHERE login='$login'"));
    $iduser=$user['id'];
?>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>eAsem-Learning</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="images/favicon.ico" />
</head>

<body>

    <?php
			$getInfo = trim(strip_tags($_GET['page']));
			
		 if ($getInfo == examen ) {
					include ("page.html");
				}
				
			
			else {
				include ("first_index.php");	
			}	
			?>

    <div id="footer">
    	<div class="container">
        
        	<div class="footer_column long">
                <h3>&copy; Designed by Cebotarenco Dan</h3>
                <p></p>
			</div>

	        <div class="footer_column">
              
            </div>
            
            <div class="footer_column">
               
            </div>
        
        </div>
    </div>
</body>
</html>
<?php
}
else{
    header("LOCATION: index.php");
}

?>