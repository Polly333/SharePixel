<?php 
 
 require_once 'connection.php';
 
 $response = array();

 
 
 if(isset($_GET["story_id"])){
	 
	$story_id = $_GET["story_id"];
	 
	
	 
	 $query = $con->prepare("DELETE FROM stories WHERE id =  ? ");
	
	
	//binding parameters to two queries
	$query->bind_param("i",$story_id);
			
			
						if($query->execute()){
							
							$response['error'] = false;
							$response['message'] = 'Post Removed Successfully';
							
					
						
						}else{
							$response['error'] = true;
							$response['message'] = 'Failed to remove Post';
							
						}
	 
	 
	 
 }else{
	 
	 $response['error'] = true;
     $response['message']= 'not all parameters are set'; 
	 
 }
 
 echo json_encode($response);
 
 
 
 ?>