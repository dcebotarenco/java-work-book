<?php
include "db.php";

/**
 * @author Dan
 * @copyright 2012
 */

if($_SERVER['REQUEST_METHOD']=="POST"){
    $idu=$_GET['iduser'];
    $intr1=$_POST['intr1'];
    $intr2=$_POST['intr2'];
    $intr2=$_POST['intr2'];
    $rs1=$_POST['rs1'];
    $rs2=$_POST['rs2'];
    $rs3=$_POST['rs3'];
    $nota_std=$_POST['nota_std'];
    $sql = "INSERT INTO test(id_user, intr1, intr2, intr3, rs1, rs2, rs3, data, nota_std)
						VALUES ('$idu','$intr1','$intr2','$intr3','$rs1','$rs2','$rs3',CURDATE(),'$nota_std')";
   mysql_query($sql)or die(mysql_error()); 
?>
<script type="text/javascript">
alert("Testul a fost trimis cu succes!");
</script>
<?php
header("LOCATION: first.php");
}


?>