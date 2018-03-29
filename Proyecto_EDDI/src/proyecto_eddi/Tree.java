/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author david
 */
public class Tree {

    private TreeNode Root;

    public Tree() {
        this.Root = null;
    }

    public Tree(TreeNode Root) {
        this.Root = Root;
    }

    public TreeNode getRoot() {
        return Root;
    }

    public void setRoot(TreeNode Root) {
        this.Root = Root;
    }

    public void clear() {
        this.Root = null;
    }

    public TreeNode addChild(TreeNode child) {
        child.setParent(this.Root);
        this.Root.getChildren().add(child);
        return child;
    }

    public void addChildren(ArrayList<TreeNode> children) {
        for (int i = 0; i < children.length(); i++) {
            this.Root.getChildren().get(i).setParent(this.Root);
        }

        for (int i = 0; i < children.length(); i++) {
            this.Root.getChildren().add(children.get(i));
        }
    }

    public void printTree(TreeNode node, String appender) {
        System.out.println(appender + node.getData());
        for (int i = 0; i < this.Root.getChildren().length(); i++) {
            this.Root.getChildren().get(i).printTree(this.Root.getChildren().get(i), appender + appender);
        }
    }

    public void CalificarNodo(TreeNode node) {
        if (!node.isLeaf(node)) {
            node.getData().setCalificacion(node.CalificarHijos(node, 0) / node.getChildren().length());
        }
        for (int i = 0; i < this.Root.getChildren().length(); i++) {
            this.Root.getChildren().get(i).CalificarNodo(node);
        }
    }

    public boolean isLeaf(TreeNode node) {
        return (node.getChildren().length() == 0);
    }

    public float CalificarHijos(TreeNode node, float num) {
        if (node.isLeaf(node)) {
            return node.getData().getCalificacion();
        } else {
            for (int i = 0; i < node.getChildren().length(); i++) {
                num += node.getChildren().get(i).getData().getCalificacion();
                node.getData().setCalificacion(num);
            }
        }
        return node.getData().getCalificacion();
    }

    public static void main(String[] args) {
        TreeNode CEO = new TreeNode(new Empleado(90, "Josue", "Ceo"));
        TreeNode Chief = new TreeNode(new Empleado(100, "David", "CHIEF PROGRAMMER"));
        TreeNode Chief2 = new TreeNode(new Empleado(50, "Iliana", "CHIEF PROGRAMMER"));
        TreeNode Progra = new TreeNode(new Empleado(60, "gato", "programador"));
        TreeNode Progra2 = new TreeNode(new Empleado(60, "Perro", "programador"));
        Tree t = new Tree(CEO);
        t.addChild(Chief);
        t.addChild(Chief2);
        Chief.addChild(Progra);
        Chief.addChild(Progra2);
        Chief.CalificarNodo(Chief);
        t.CalificarNodo(t.getRoot());
        t.printTree(CEO, "-");
    }
}
