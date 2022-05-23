public class WaitingList {
    protected Node head;
    protected int numNodes;

    public WaitingList(){
        this.head = null;
        this.numNodes = 0;
    }

    /**
     * This method will pop the first patient from the waiting list
     * @return the patient popped from the waiting list
     */
    public Patient popPatient() 
    {
        if(head==null) //if head null, wait list empty
        {
            return null;
        }
        Node tmp=head; //temp node to hold head
        head=head.getNext(); //assign head to the next in line as current head is about to be popped
        return tmp.getPatient(); //return (pop) head, and get patient from that node
    }

    /**
     * This method will add patient into the waiting list according to the triage level
     * @param patient patient's data
     */
    public void addToList(Patient patient) 
    {
        Node tmp=new Node(patient); //temp node to hold the patient passed into method
        if(head==null) //if waitlist is empty
        {
            head=tmp; //head becomes patient passed in
        }
        else //else
        {
            Node curr=head,prev=head; //two pointers to compare current and previous
            while(curr.getNext()!=null) //while there is more than 1 patient
            {
                if((tmp.getPatient().getTriageLevel()<curr.getPatient().getTriageLevel()) ||(tmp.getPatient().getTriageLevel()==curr.getPatient().getTriageLevel())) //checking triage level of passed in patient and curr pointer
                {
                    tmp.setNext(curr.getNext()); //if tmp greater/equal to curr, set tmp "next" to the one after curr (as curr triage lower, hence more serious triage level)
                    curr.setNext(tmp); //set curr to tmp, so curr is now infront of tmp
                    return;
                }
                prev=curr; 
                curr=curr.getNext(); //update curr pointer
            }
            if(tmp.getPatient().getTriageLevel()<curr.getPatient().getTriageLevel() && curr==head) //if tmp triage < curr and curr is head
            {
                tmp.setNext(curr); //curr goes behind tmp
                head=tmp; //tmp becomes head
            }
            else if(tmp.getPatient().getTriageLevel()==curr.getPatient().getTriageLevel() && curr==head) //if equal
            {
                tmp.setNext(curr); //tmp goes to front
                head=tmp;
            }
            else if(tmp.getPatient().getTriageLevel()<curr.getPatient().getTriageLevel())  
            {
                tmp.setNext(curr);
                prev.setNext(tmp);
            }
            else if(tmp.getPatient().getTriageLevel()==curr.getPatient().getTriageLevel()) 
            {
                tmp.setNext(curr);
                prev.setNext(tmp);
            }
            else 
            {
                curr.setNext(tmp); //if tmp triage > curr, tmp behind curr
            }
        }
    }
    

    /**
     * print out the information for each patient in waiting list
     */
    public void printList() 
    {
        Node curr=head;
        while(curr!=null) 
        {
        curr.printNode();
        curr=curr.getNext();
        }
    }
    /**
     * Check whether the patient is in this list or not
     * @return
     */
    public boolean isInList(Patient patient) {
        if (this.head == null) {
            return false;
        }
        Node temp = this.head;
        while(temp != null) {
            if(temp.getPatient().getName().equals(patient.getName())
                    && temp.getPatient().getPhoneNumber().equals(patient.getPhoneNumber())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void remove(int id) { //helper method
        if(this.head != null) {

            Node temp = this.head;
            Node prev = null;

            do {

                if (temp.patient.getId() == id) {

                    if(prev != null) {

                        prev.next = temp.next;
                        temp = temp.next;

                    } else {

                        this.head = this.head.next;
                        prev = null;
                        temp = this.head;
                    }

                } else {

                    prev = temp;
                    temp = temp.next;

                }

            } while(temp != null);
        }
    }
    public int getNumberPatients(int id) { //helper method
        int counter = 0;
        Node pointer = head;

        if(this.head == null) //checks if head is null, if it is list empty, return -1
        {
            return -1;
        }
        else if(this.head.getPatient().getId() == id) //checks to see if head is patient with desired ID, if it is, return 0 (as 0 people infront of this patient, they are at the front)
        {
            return 0;
        }
        while(pointer.getPatient().getId() != id && pointer.getNext() != null) //whiel loop to traverse (while ID is not desired and .next isn't null), will continue till desired ID is found
        {
            pointer = pointer.getNext(); //update pointer to next node
            counter++; //incrementing counter (which is how many people are in front of patient we are searching for as this starts from head (the front))
        }
        return counter; //returns final counter once id is found which will be how many people are head of the desired patient
    }

    public boolean isEmpty()
    {
        if(this.head != null) //if head is not null, list is not empty
        {
            return false; //return false
        }
        else
        {
            return true; //if list empty return true
        }
    }
}

