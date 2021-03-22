package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {
    private List<Cleanable> cleanables = new ArrayList();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int result = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            Cleanable cleanable = iterator.next();
            result += cleanable.clean();
            iterator.remove();
        }
        return result;
    }

    public int cleanOnlyOffices() {
        int result = 0;
        Iterator<Cleanable> iterator = cleanables.iterator();
        while (iterator.hasNext()) {
            Cleanable cleanable = iterator.next();
            if (cleanable instanceof Office) {
                result += cleanable.clean();
                iterator.remove();
            }
        }
        return result;
    }

    public List<Cleanable> findByAddressPart(String address) {
        if (address == null) {
            throw new IllegalArgumentException("The address is null ...");
        }

        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder result = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            result.append(cleanable.getAddress() + ", ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}
