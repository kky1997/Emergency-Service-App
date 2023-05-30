# Emergency-Service-App
An emergency service app for patient waitlist and ambulance distribution (all done through CLI)

Key features of this app are:

1. add patients to a waitlist - this allows the user to input patient data (name, phone number, triagelevel, location) and will queue this patient into a queue based on their triagelevel (1 is highest priority, 5 lowest)
				if a pateint already in the queue has has the same triagelevel as a patient to be added, the patient already in the queue is given priority.
				This function only allows triaglevels 1-5 to be input and only integers, anything else will prompt user to input again.

2. assign an ambulance - this just dequeues the patient at the front of the queue (based on triagelevel) and prints a message to indicate an ambulance has been dispatched for them.
			 patient which has had an ambulance dispatched for them will no longer show up in the queue (they have been dequeued). If list is empty, will return a message to inform the user.

3. assign an ambluance by ID - this, like the above function, assigns an ambulance to a patient, but is direct by the user via inputting a patients ID (id number is auto generated whenever a patient is added to the queue)
			       patient is also dequeued once an ambluance is dispatched to them. If list is empty, will return a message to inform the user.

4. find out how many patients in front of said patient - this works by using a helper method (getNumbPatients()) which just traverses the queue until it finds the desired patient's ID number, each traversal increments a counter
							 so once the desired patient has been found, the counter is returned, detailing how many patients are in front of said patient.

5. print the current list - this will print the current list of patients in the waiting list, in order of their triagelevel (from top to bottom)

0. exists the program
