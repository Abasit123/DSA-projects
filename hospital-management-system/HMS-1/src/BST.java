public class BST {
    private Patient patient;
    private BST left, right;
    static final BST nill = new BST();

    BST() {
        left = right = this;
    }

    BST(Patient patient) {
        this.patient = patient;
        this.left = this.right = nill;
    }

    public BST add(Patient P) {
        if (this == nill) {
            return new BST(P);
        }

        if (P.age == patient.age) {
            return this;
        }

        if (P.age > patient.age) {
            right = right.add(P);
        } else {
            left = left.add(P);
        }

        return this;
    }
}
