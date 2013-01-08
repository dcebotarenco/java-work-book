<?php include("db.php");?>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>eAsem-Learning</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="images/favicon.ico" />
</head>

<body>
    <div id="main">
    	<div class="container">
        
        	<div id="header">
                
                <ul id="menu">
                	 <li><a href="registration.php" style="font-size: 14px;">Registrare</a></li>          
                </ul>
           
            	<div id="logo">
                	
                </div>
            
            </div>
            
            <div id="block_featured" class="block">
				
            	<div class="block_inside">
                
                
                    
                        <div class="login_Block">
                        <h2>Autentificare</h2>
                        <form action="" method="POST">
                        <div class="loginLeft">
                        <p>Login:</p>
                        <p>Parola:</p>
                        
                      </div>  
                        <div class="regRight">
                          <label>  <input type='text' name="login"/></label><br />
                          <label> <input type='password'name="pass"/></label><br />
                                   
                         </div>     
                         <br>       
                        <input type="submit" class="button" value="Login"/>    
                        
                        </form>
                        <?php
                        
                            if($_SERVER['REQUEST_METHOD']=="POST"){
                                $sql=mysql_query("SELECT * FROM users WHERE login='$_POST[login]' and password='$_POST[pass]'");
                                if(mysql_num_rows($sql)==1){
                                    $log=mysql_fetch_array($sql);
                                    
                                setcookie('login',$log['login'],time()+3600);
                                setcookie('pass',$log['password'],time()+3600);
                                
                                header("LOCATION: first.php");
                                
                              }else{
                                echo "<h1>Datele introduse sunt incorecte!</h1>";
                                
                              }
                                }
                            
                            
                        ?>
                       </div>                             
                	
                    
                </div>
            </div>
            
            
               
	
      </div>
        
    </div>
    


    <div id="footer">
    	<div class="container">
        
        	
        
        </div>
    </div>
</body>
</html>