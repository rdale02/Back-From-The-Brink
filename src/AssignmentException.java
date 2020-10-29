class AssignmentException extends Exception {
    /**
     * ConstructionException is thrown when an assignment fails.
     * Common use case is within a setter
     * @param msg describes the reason for assignment failure.
     * @author Ronan
     */
    public AssignmentException(String msg){
        super(msg);
    }

}
