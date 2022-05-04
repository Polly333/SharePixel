<?php 
 
 require_once 'connection.php';
 
 $response = array();
 
					 
	             
$stmt = $con->prepare("SELECT * FROM stories WHERE num_of_reports >=1 "); //imp
$stmt->execute();
				
$stories = array();
$result = $stmt->get_result();
while ($row = $result->fetch_array(MYSQLI_ASSOC))
	{
		$stories[] = $row;
							
					
	}
						
$response['error'] = false;						
$response['stories'] = $stories ; 
$stmt->close();
	
 
 
  
 echo json_encode($response);
 

 
 
 ?>