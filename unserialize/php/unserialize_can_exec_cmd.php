<?php
class CmdClass
{
   public $hook;

   function __wakeup()
   {
      if (isset($this->hook)) eval($this->hook);
   }
}

$user_data = unserialize($_REQUEST['data']);
?>
