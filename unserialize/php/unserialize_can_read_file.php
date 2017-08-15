<?php   
class FileClass  
{  
    // 文件名  
    public $filename = 'error.log';  

    // 当对象被作为一个字符串会读取这个文件  
    public function __toString()  
    {  
        return file_get_contents($this->filename);  
    }  
}  
   
// 用户可控  
$obj = unserialize($_GET['data']);  
   
// 输出__toString  
echo $obj;  
?>
