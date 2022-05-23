public class ServiceCenter {
    private WaitingList awl;

    public ServiceCenter() {
        this.awl = new WaitingList();
    }

    /**
     * Record patient's data and add the patient into waiting list
     * @param name
     * @param phoneNumber
     * @param triageLevel
     * @param location
     */
    public void addPatientIntoList(String name, String phoneNumber, int triageLevel, String location) {
        Patient patient = new Patient(name, phoneNumber, triageLevel, location);
        if(this.awl.isInList(patient)){
            System.out.println(patient.getName() + " is in waiting list. ");
        }else{
            this.awl.addToList(patient);
            System.out.println("Add " + patient.getName() + " into waiting list. ");
        }
    }

    /**
     * Pop out the first patient in the waiting list and assign an Ambulance for him/her
     * @return the patient object
     */
    public Patient assignAmbulanceForPatient() 
    {
        // TODO: The tester report that the system will crash when waiting list is empty
        try 
        {
            Patient patient = this.awl.popPatient();
            System.out.println("Assigned an ambulance for patient: " + patient.getName());

        }

        catch (Exception e) 
        {
            System.out.println("Error! the waiting list is empty.");
        }
        return null;
    }

    /**
     * Print out the waiting list
     */
    public void printWaitingList(){
        this.awl.printList();
    }

    public void assignAmbulance(int id) 
    {

        awl.remove(id); //remove id
        if(awl.isEmpty() == true) //if list is empty
        {
            System.out.println("Error! the waiting list is empty."); //print following
        }
        else
        {
        System.out.println("Success! An ambulance as assigned for patient " + id + "."); //otherwise print this
        }
    }

    public void checkPos(int id) 
    {
        int number = awl.getNumberPatients(id);
        System.out.println("There are " + number + " patients before patient " +  id + ".");
    }
}

