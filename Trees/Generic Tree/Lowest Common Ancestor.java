 public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }
  public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> a1 = nodeToRootPath(node,d1);
    ArrayList<Integer> a2 = nodeToRootPath(node,d2);

    int lca=-1;
    int i=a1.size()-1;
    int j=a2.size()-1;

    while(i>=0 && j>=0)
    {
      if(a1.get(i)!=a2.get(j))
      {
        break;
      }
      else{
        lca=a1.get(i);
        i--;
        j--;
      }
    }
    return lca;
  }
