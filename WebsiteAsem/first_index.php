    <div id="main">
    	<div class="container">
        
        	<div id="header">
            
            	<ul id="menu" style="color: #000;font-size:16px;">
                	<?php include "time.htm";?>
                	        
                </ul>
                
            	<div id="logo">
                	
                </div>
            
            </div>
            
            <div id="block_featured" class="block">
				
            	<div class="block_inside">
                
                	<div class="image_block">
                    	<img src="images/second-hand-books.jpg" alt="Eden"/>
                    </div>
                    <div class="text_block">
                        <h2>Online Testare</h2>Fii sigur ca o sa sustii ;) 
                        
                        <p> Acest site este un nou pas in dezvoltarea individuala a fiecarui din Noi - profesor si studient.</p>
                        <br />
                        <a href="first.php?page=examen" class="button">Lanseaza testul!</a>
                	</div>
                    
                </div>
            </div>
            
            <div id="block_portfolio">
            
            	<div id="portfolio_items">
                
                	<div class="mini_portfolio_item">
                    	
                    	<div class="block_inside">
                            <img src="images/calendar_icon3.png" class="thumbnail" alt="AudioJungle" />
                            <h3>Testari</h3>
                            <p>Vezi cind ai de Zubrit <a href="#">Orarul Zilelor negre :P</a></p>
                        </div>                    
                    </div>
                    
                	<div class="mini_portfolio_item">
                    	<div class="block_inside">
                            <img src="images/moodle5.jpg" class="thumbnail"  alt="CollisTaeed" />
                            <h3>Treci pe Moodle</h3>
                            <p>Iati Cursurile Online <a href="#">de aici</a></p>
                        </div>                    
                    </div>
                    
                    <div class="mini_portfolio_item">
                    	<div class="block_inside">
                            <img src="images/asemlogo.gif" class="thumbnail" alt="PSDTUTS"  />
                            <h3>Saitul Oficial Asem</h3>
                            <p>Afla mai mult despre universitatea Ta! <a href="#">ase.md</a></p>
                        </div>                    
                    </div>
                
                </div>
                
                <div id="text_column">
                <div class="mini_portfolio_item">
                 <div class="block_inside">
                 <img src="images/avatar.png" class="thumbnail" alt="PSDTUTS" style="background-color: #fff;" />
                 <h3>Miniprofil</h3><br /><a href="end.php">Iesire</a>
                 <h1>Salut!</h1>
                 <span class="mini_profil_text">username:</span><?php echo $user['login']; ?><br />
                <span class="mini_profil_text"> Nume:</span><?php echo $user['nume']; ?><br />
                <span class="mini_profil_text"> Prenume:</span><?php echo $user['prenume']; ?><br />
                 <span class="mini_profil_text">Grupa:</span><?php echo $user['grupa']; ?><br />
                 
                 </div>
                 </div>
                    
			    </div>
	
            </div>
        
        </div>
    </div>
