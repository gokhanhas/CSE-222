/*
 * Gokhan Has - 161044067
 */


import java.util.Iterator;

/**
 * This is the ExperimentList class to keep track of some
 * machine learning experiments and their results.
 *
 * @author GokhanHas
 */
public class ExperimentList<myIterator> implements Iterable<ExperimentList>, Iterator<ExperimentList> {
    /**
     * It keeps the first element of list.
     */
    private ExperimentNode head;

    /**
     * It is used to Iterator methods.
     */
    private ExperimentNode iterator;

    /**
     * It keeps the size of linked-list.
     */
    private int size;

    /**
     * ExperimentNode class private static class.
     * It will be used linked-list methods.
     */
    private static class ExperimentNode {
        /**
         * It keeps the Experiment referances which
         * will be added in linked-list.
         */
        private Experiment data;

        /**
         * It keeps the next node in linked-list.
         */
        private ExperimentNode next;

        /**
         * It keeps the different first day.
         * For Exapmle the day 1's nextDay node keeps day 2 if it is exist.
         */
        private ExperimentNode nextDay;

        /**
         * This is constructor
         * @param exp the Experiment class referances.
         */
        public ExperimentNode(Experiment exp) {
            this.data = exp;
            this.next = null;
            this.nextDay = null;
        }


        /**
         * This is the constructor
         * @param expNode the ExperimentNode class referances.
         */
        public ExperimentNode(ExperimentNode expNode) {
            this.data = expNode.data;
            this.next = expNode.next;
            this.nextDay = expNode.nextDay;
        }

        /**
         *
         * @return ExperimentList data's.
         */
        public Experiment getData() {
            return this.data;
        }

        /**
         * Set the ExperimentList data
         * @param exp the Experiment class referances.
         */
        public void setData(Experiment exp) {
            this.data = exp;
        }

        /**
         *
         * @return ExperimentNode next node.
         */
        public ExperimentNode getNext() {
            return next;
        }

        /**
         * Set the ExperimentList next node
         * @param next the ExperimentNode referances.
         */
        public void setNext(ExperimentNode next) {
            this.next = next;
        }

        /**
         *
         * @return ExperimentNode next first day.
         */
        public ExperimentNode getNextDay() {
            return this.nextDay;
        }

        /**
         * Set the ExperimentList nextDay node
         * @param nextDay the ExperimentNode referances.
         */
        public void setNextDay(ExperimentNode nextDay) {
            this.nextDay = nextDay;
        }

    }

    /**
     *
     * @return true if the iterator next is not null.
     */
    @Override
    public boolean hasNext() {
        if(iterator.next == null) {
            System.out.println("ERROR ! Iterator.next is null");
            return false;
        }
        return true;
    }

    /**
     *
     * @return ExperimentList if the list next element is exist.
     */
    @Override
    public ExperimentList next() {
        if(hasNext() == true)
            iterator = iterator.next;

        return this;
    }


    /**
     * Remove the element which is showed by iterator
     * @throws Exception if the iterator next element is null.
     */
    @Override
    public void remove() {
        if (iterator.next != null) {
            if(iterator.next.next != null) {
                iterator.next = iterator.next.next;
            }
            else
                iterator.next = null;
        }
        else{
            throw new NullPointerException("Iteration.next is null !");
        }
    }


    /**
     *
     * @return Iterator<ExperimentList> head.
     */
    @Override
    public Iterator<ExperimentList> iterator() {
        iterator = head;
        return this;
    }

    /**
     *
     * @return Experiment referances which is pointed by iterator.
     */
    public Experiment getIteratorData() {
        return iterator.data;
    }

    /**
     * This no parameter constructor.
     */
    public ExperimentList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * This is constructor
     * @param newList is another ExperimentList referances.
     */
    public ExperimentList(ExperimentList newList) {
        this.head = newList.head;
        this.size = newList.size;
    }

    /**
     *
     * @return the linked-list size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     *  Method that adding Experiment referances the linked-list.
     *  It controlled the three statements.Adding head,middlee and last.
     *  Insert experiment to the end of the day.
     * @param experiment the Experiment referances.
     */
    public void addExp(Experiment experiment) {

        if(head == null) {
            // Eger liste bos ise
            head = new ExperimentNode(experiment);
            size++;
            return;
        }

        ExperimentNode tempHead = head;

        if(experiment.getDay() < tempHead.data.getDay()) {
            // Head degisirse ...
            ExperimentNode tempNode = new ExperimentNode(experiment);
            tempNode.next = head;
            tempNode.nextDay = head;
            head = tempNode;
            size++;
            return;
        }

        else if(experiment.getDay() == tempHead.data.getDay()) {

            ExperimentNode tempNode = new ExperimentNode(experiment);

            while (tempHead.next != null && tempHead.next.data.getDay() == experiment.getDay())
                tempHead = tempHead.next;
            tempNode.next = tempHead.next;
            tempHead.next = tempNode;
            size++;
            return;
        }

        else if(experiment.getDay() > tempHead.data.getDay()) {

            tempHead = new ExperimentNode(head);
            ExperimentNode tempFirstDay = new ExperimentNode(head);
            ExperimentNode tempNode = new ExperimentNode(experiment);

            while (tempHead.next != null) {

                if(tempFirstDay.data.getDay() != tempHead.data.getDay()) {
                    tempFirstDay = tempHead;
                }

                int control=0;
                if(experiment.getDay() < tempHead.next.data.getDay()) {

                    //Araya ekleme koşulu...
                    tempNode.next = tempHead.next;
                    tempNode.nextDay = tempFirstDay.nextDay;
                    tempHead.next = tempNode;
                    tempFirstDay.nextDay = tempNode;
                    size++;
                    return;
                }


                else if(experiment.getDay() == tempHead.next.data.getDay()) {

                    tempHead = tempHead.next;
                    control = -1;

                    tempNode.next = tempHead.next;
                    tempHead.next = tempNode;


                    size++;
                    return;
                }

                if(control == 0)
                    tempHead = tempHead.next;
            }


            tempHead = new ExperimentNode(head);

            if(size == 1) {
                head.next = tempNode;
                head.nextDay = tempNode;
                size++;
                return;
            }

            while (tempHead.next != null)
                tempHead = tempHead.next;

            ExperimentNode tempNode2 = new ExperimentNode(experiment);
            tempHead.next = tempNode2;

            if(tempHead.data.getDay() != experiment.getDay())
                tempHead.nextDay = tempNode2;
            size++;
            return;
        }
    }

    /**
     *
     * @param day the day number in the linked-list
     * @param index the position which experiment of the day.
     * @return null if the day does not exist other return Experiment.
     */
    public Experiment getExp(int day,int index) {

        ExperimentNode tempNode = new ExperimentNode(head);

        if(tempNode.data.getDay() == day) {

            if(index == 0)
                return tempNode.data;

            int i=0;
            while(tempNode.data.getDay() == day) {
                if(index == i)
                    return tempNode.next.data;
                tempNode = tempNode.next;
                i++;
            }
            return null;
        }

        while(tempNode.nextDay != null) {

            if(day == tempNode.nextDay.data.getDay()) {

                if(index == 0)
                    return tempNode.nextDay.data;
                else{
                    ExperimentNode dayNode = tempNode.nextDay;
                    int i=0;
                    while(dayNode.next != null && dayNode.data.getDay() == day){
                        if(index == i)
                            return dayNode.data;
                        dayNode = dayNode.next;
                        if(dayNode.next == null)
                            return dayNode.data;
                        i++;
                    }
                }
            }
            tempNode.nextDay = tempNode.nextDay.nextDay;
        }
        return null;
    }


    /**
     * Set the experiment with the given day and position
     * @param day the day number in the linked-list.
     * @param index the position which experiment of the day.
     * @param experiment keeps information of the experiment to be changed.
     */
    public void setExp(int day,int index,Experiment experiment) {
        //Aynı gunden yoksa bu fonksıyon ekleme yapmaz!!!
        ExperimentNode tempNode = head;

        while(tempNode != null) {

            if(tempNode.data.getDay() == experiment.getDay()) {

                int indexCount = 0;
                while(tempNode.next != null && tempNode.next.data.getDay() == day) {

                    if(indexCount == index) {
                        tempNode.data = experiment;
                        return;
                    }

                    indexCount++;
                    tempNode = tempNode.next;
                }

                // SONUNCUSUNU KONTROL EDIYOR...
                if(indexCount == index) {
                    tempNode.data = experiment;
                    return;
                }
                else
                    return;

            }

            tempNode = tempNode.next;
        }
    }

    /**
     * Remove the experiment specified as index from a given day
     * @param day the day number which be removed in the linked-list.
     * @param index the position which experiment of the day.
     * @throws Exception if the day does not exist.
     */
    public void removeExp(int day,int index) throws Exception {

        ExperimentNode tempControl = head;
        ExperimentNode tempRemovedDay = head;
        ExperimentNode tempDayNode = head;
        boolean controlSameDay = false;


        if(head.data.getDay() == day) {

            if (index == 0) {
                ExperimentNode newNextDay = new ExperimentNode(head.nextDay);
                head = head.next;
                head.nextDay = newNextDay;
                size--;
                return;
            }
            else {

                int indexCount = 0;
                while (tempRemovedDay.data.getDay() == day ) {

                    if(indexCount == index-1) {
                        tempRemovedDay.next = tempRemovedDay.next.next;
                        size--;
                        return;
                    }

                    indexCount++;
                    tempRemovedDay = tempRemovedDay.next;
                }
            }
        }


        while(tempControl.nextDay != null) {

            if(day == tempControl.nextDay.data.getDay()){
                controlSameDay = true;
                tempRemovedDay = tempControl.nextDay;
                tempDayNode = tempControl;
            }

            tempControl = tempControl.nextDay;
        }

        if(!controlSameDay) {
            System.out.println("\nError! You request the wrong day.Exception will be throwed.");
            throw new Exception();
        }

        ExperimentNode newExperimentNode = tempDayNode;

        if(tempRemovedDay.next == null) {
            // Sonuncuyu silme koşulu
            tempDayNode.nextDay = null;
            tempDayNode.next = null;
            size--;
            return;
        }

        else if(index == 0 && tempRemovedDay.next.data.getDay() == day) {
            // Birden fazla aynı günde elemanın olup ilkini silme koşulu...
            while (tempDayNode.data.getDay() == tempDayNode.next.data.getDay()) {
                tempDayNode = tempDayNode.next;
            }

            newExperimentNode.nextDay = tempRemovedDay.next;
            newExperimentNode.nextDay.nextDay = tempRemovedDay.nextDay;
            //System.out.println("YYYYYY ->>>>  " + newExperimentNode.nextDay.data);
            tempDayNode.next = tempDayNode.next.next;

            size--;
            return;
        }

        else if(index == 0 && tempRemovedDay.next != null) {
            // sadece bir gün olanın silme koşulu ...
            tempDayNode.next = tempRemovedDay.next;
            tempDayNode.nextDay = tempRemovedDay.nextDay;
            size--;
            return;
        }

        else {
            // arada bir yeri silme koşulu ...
            int indexCount = 0;
            while(tempRemovedDay.data.getDay() == day && tempRemovedDay.next != null) {

                if(indexCount == index - 1) {
                    tempRemovedDay.next = tempRemovedDay.next.next;

                    size--;
                    return;
                }

                indexCount++;
                tempRemovedDay = tempRemovedDay.next;
            }
        }
    }


    /**
     * List all completed experiments in a given day.
     * @param day the day number which be listed in the linked-list.
     * @return ExperimentList which completes are true.
     * @throws Exception if the day does not exist in linked-list.
     */
    public ExperimentList listExp(int day) throws Exception {

        ExperimentNode tempHead = head;
        ExperimentNode tempDayNode = head;
        ExperimentList newList = new ExperimentList();

        if(head.data.getDay() == day) {
            tempDayNode = head;
        }
        else {

            boolean control = false;
            while (tempHead != null) {

                if(tempHead.data.getDay() == day && control == false) {
                    tempDayNode = tempHead;
                    control = true;
                }
                tempHead = tempHead.nextDay;
            }
        }

        boolean control = false;
        while(tempDayNode != null && day == tempDayNode.data.getDay()) {

            if(tempDayNode.data.getCompleted() == true) {

                newList.addExp(tempDayNode.data);
                System.out.print(tempDayNode.data);
                control = true;
            }
            tempDayNode = tempDayNode.next;
        }

        if(control == false) {
            System.out.println("ERROR ! The day , which you entered , not found.Exception will be throwed !!");
            throw new Exception();
        }

        return newList;
    }

    /**
     * Remove all experiments in a given day.
     * @param day the day number which be removed all experiments in the linked-list.
     */
    public void removeDay(int day) {

        ExperimentNode tempHead = head;
        ExperimentNode removedDay = head;

        if(head.data.getDay() == day) {
            // headi silme dururmu ...
            ExperimentNode newNode = new ExperimentNode(head.nextDay);
            head = newNode;
            removedDay = head;
        }
        else {
            //Digerlerini silme durumu ...
            boolean control = false;
            while (tempHead.nextDay != null) {

                if (tempHead.nextDay.data.getDay() == day && control == false) {

                    tempHead.nextDay = tempHead.nextDay.nextDay; // Bunla gun nodelarını bagladık
                    tempHead.next = tempHead.nextDay;
                    control = true;
                }
                tempHead = tempHead.nextDay;
            }
        }

        // Boyutun yeniden hesaplanması ...
        this.size = 0;
        while(removedDay != null) {
            size++;
            removedDay = removedDay.next;
        }
    }

    /**
     * Sorts the experiments in a given day according to the accuracy.
     * It changed the list.
     * @param day the day number which be ordered in the linked-list.
     */
    public void orderDay(int day) {

        ExperimentNode tempNode = head;
        ExperimentNode orderDay = head;
        Experiment[] tempArray = new Experiment[50];

        int arraySize = 0;
        boolean control = false;
        while(tempNode != null && control == false) {

            if(tempNode.data.getDay() == day ) {
                orderDay = new ExperimentNode(tempNode);
                tempArray[arraySize] = tempNode.data;
                arraySize++;

                while(tempNode.next != null && tempNode.next.data.getDay() == day) {
                    tempArray[arraySize] = tempNode.next.data;
                    arraySize++;
                    tempNode = tempNode.next;
                }
                control = true;
            }
            tempNode = tempNode.next;
        }

        Experiment[] newArray = new Experiment[arraySize];
        for(int i=0;i<arraySize;++i) {
            newArray[i] = tempArray[i];
        }
        bubbleSort(newArray);
        for(int i=0;i<arraySize;++i) {
            setExp(day,i,newArray[i]);
        }
    }

    /**
     * Sorts all the experiments in the list according to the accuracy.
     * This method does NOT change the original linked-list.
     * @return new ExperimentList.
     */
    public ExperimentList orderExperiments() {

        Experiment[] experimentArray = new Experiment[size];
        ExperimentNode tempHead = head;

        int index = 0;
        while(tempHead != null) {
            experimentArray[index] = tempHead.data;
            index++;
            tempHead = tempHead.next;
        }
        bubbleSort(experimentArray);

        ExperimentList returnExperimentList = new ExperimentList();
        returnExperimentList.head = new ExperimentNode(experimentArray[0]);
        ExperimentNode newHead = returnExperimentList.head;

        for(int i=1; i< experimentArray.length;i++) {
            newHead.next = new ExperimentNode(experimentArray[i]);
            newHead = newHead.next;
        }

        return returnExperimentList;
    }

    /**
     *
     * @return head the first node in linked-list.
     */
    public ExperimentNode getHead() {
        return head;
    }


    /**
     * Overriding the object class toString method.
     * @return String the Experiment properties which are keeped in ExperimentNode.
     */
    @Override
    public String toString() {
        String returnStr = "Total List : \n";
        ExperimentNode tempNode = new ExperimentNode(head);


        while (tempNode != null) {
            returnStr = returnStr + tempNode.data.toString();
            tempNode = tempNode.next;
        }

        return returnStr;
    }

    /**
     * Printing the first experiments of the days.
     */
    public void printDayNode() {

        ExperimentNode tempHead = new ExperimentNode(head);
        System.out.print(tempHead.data);

        while (tempHead.nextDay != null) {
            System.out.print(tempHead.nextDay.data);
            tempHead = tempHead.nextDay;
        }

    }

    /**
     * List the accuracy of experiments from small to big.
     * @param array is Experiment array.
     */
    private void bubbleSort(Experiment[] array) {
        int length = array.length;
        Experiment temp = new Experiment();

        for(int i=0; i < length; i++){
            for(int j=1; j < (length-i); j++){

                if(array[j-1].getAccuracy() > array[j].getAccuracy()){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}