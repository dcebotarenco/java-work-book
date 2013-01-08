<?php

/**
 * @author Dan
 * @copyright 2012
 */

setcookie("login",time()-36000);
setcookie("password",time()-36000);
header("LOCATION: index.php");
?>