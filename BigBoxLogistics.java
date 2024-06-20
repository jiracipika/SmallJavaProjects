import java.util.ArrayList;
import java.util.List;

// Implement interface
interface PackageInterface {
    void addSubPackage(Package pkg);
    int getTotalWeight();
}

class Package implements PackageInterface {
    private int weight;
    private List<Package> subPackages;

    public Package(int weight) {
        this.weight = weight;
        this.subPackages = new ArrayList<>();
    }

    // Add a subpackage
    public void addSubPackage(Package pkg) {
        subPackages.add(pkg);
    }

    // Calculate total weight
    public int getTotalWeight() {
        int totalWeight = this.weight; // Initial weight
        for (Package p : subPackages) {
            totalWeight += p.getTotalWeight(); // Add weight with each sub-package
        }
        return totalWeight;
    }
}

// Test cases
class BigBoxLogistics {
    public static void main(String[] args) {
        // Test Case 1
        Package p1 = new Package(1);
        Package p2 = new Package(2);
        p1.addSubPackage(p2);
        System.out.println(p1.getTotalWeight());

        // Test Case 2
        p1 = new Package(1);
        p2 = new Package(2);
        Package p3 = new Package(3);
        p1.addSubPackage(p2);
        p2.addSubPackage(p3);
        System.out.println(p1.getTotalWeight());
    }
}
