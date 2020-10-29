class ConstructionException extends Exception {
    /**
     * ConstructionException is thrown when an object fails its construction.
     * @param msg describes the reason for construction failure.
     * @author Ronan
     */
    public ConstructionException(String msg){
        super(msg);
    }

}
