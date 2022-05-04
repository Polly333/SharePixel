<?php 
 
 require_once 'connection.php';
 
 $response = array();
 
 if(isset($_GET["user_id"])&& isset($_GET['story_id'])){
				
				 $story_id = $_GET["story_id"]; 
				 $user_id = $_GET['user_id'];  
				
			
	
				 $stmt = $con->prepare("INSERT INTO reports (user_id,story_id) VALUES (?,?) ");
		
				 $stmt->bind_param("ii", $user_id, $story_id);
			
			
							 
						 if($stmt->execute()){
								 $response['error'] = false;
								 $response['message'] = 'user has been added to reports database';
							
								 
								 
						 }else{
							    $response['error'] = true;
								 $response['message'] = 'could not add user to reports database!';
								
								
							 
						 }
						 
						  $stmt->close();
			
	
 
 }else{
		 $response['error'] = true; 
		 $response['message'] = 'required parameters are not available'; 
 }
 
 
 
  
 echo json_encode($response);
 

 
 
 ?>