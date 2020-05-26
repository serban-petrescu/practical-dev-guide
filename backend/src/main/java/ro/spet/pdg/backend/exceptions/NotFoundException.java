package ro.spet.pdg.backend.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("The requested entity was not found!");
    }
}
