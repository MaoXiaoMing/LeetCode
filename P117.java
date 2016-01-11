
public class P117 {
	
    public void connect(TreeLinkNode root) {
    	TreeLinkNode dummy = new TreeLinkNode(0);
    	TreeLinkNode pre = dummy;
    	while(root != null) {
    		if(root.left != null) {
    			pre.next = root.left;
    			pre = pre.next;
    		}
    		if(root.right != null) {
    			pre.next = root.right;
    			pre = pre.next;
    		}
    		root = root.next;
    		if(root == null) {
    			pre = dummy;
    			root = dummy.next;
    			dummy.next = null;
    		}
    	}
//    	//自己都绕晕了.....
//        if(root == null) return ;
//        root.next = null;
//        TreeLinkNode first = root;
//        while(first != null) {
//        	TreeLinkNode current = first;
//        	boolean fi = true;
//        	while(current != null) {
//        		if(current.left!=null && current.right!=null) {
//        			if(fi) {
//        				first = current.left;
//        				fi = false;
//        			}
//        			current.left.next = current.right;
//        			TreeLinkNode next = current.next;
//        			while(next != null) {
//        				if(next.left != null) {
//        					current.right = next.left;
//        					break;
//        				}else if(next.right != null) {
//        					current.right = next.right;
//        					break;
//        				}
//        				next = next.next;
//        			}
//        		}else if(current.left != null) {
//        			if(fi) {
//        				first = current.left;
//        				fi = false;
//        			}
//        			TreeLinkNode next = current.next;
//        			while(next != null) {
//        				if(next.left != null) {
//        					current.left = next.left;
//        					break;
//        				}else if(next.right != null) {
//        					current.left = next.right;
//        					break;
//        				}
//        				next = next.next;
//        			}
//        		}else {
//        			if(fi) {
//        				first = current.right;
//        				fi = false;
//        			}
//        			TreeLinkNode next = current.next;
//        			while(next != null) {
//        				if(next.left != null) {
//        					current.right = next.left;
//        					break;
//        				}else if(next.right != null) {
//        					current.right = next.right;
//        					break;
//        				}
//        				next = next.next;
//        			}
//        		}
//        		current = current.next;
//        	}
//        }
    }
    
    public void helper(TreeLinkNode root) {
    	if(root==null || (root.left==null && root.right==null)) return ;
    	if(root.left != null && root.right != null) {
    		root.left.next = root.right;
    		if(root.next != null) {
    			TreeLinkNode current = root;
    			while(current.next != null) {
    				if(current.next.left != null) {
    					root.right.next = current.next.left;
    					break;
    				}else if(current.next.right != null) {
    					root.right.next = current.next.right;
    					break;
    				}else if(current.next.next==null) {
    					root.right.next = null;
    					break;
    				}
    				current = current.next;
    			}
    		}else {
    			root.right.next = null;
    		}
    	}else if(root.left != null) {
    		TreeLinkNode current = root;
    		while(current.next != null) {
				if(current.next.left != null) {
					root.left.next = current.next.left;
					break;
				}else if(current.next.right != null) {
					root.left.next = current.next.right;
					break;
				}else if(current.next.next==null) {
					root.left.next = null;
					break;
				}
				current = current.next;
			}
    	}else {
    		TreeLinkNode current = root;
    		while(current.next != null) {
				if(current.next.left != null) {
					root.right.next = current.next.left;
					break;
				}else if(current.next.right != null) {
					root.right.next = current.next.right;
					break;
				}else if(current.next.next==null) {
					root.right.next = null;
					break;
				}
				current = current.next;
			}
    	}
    	helper(root.left);
    	helper(root.right);
//    	if(root==null || (root.left==null && root.right==null)) return ;
//    	if(root.left != null && root.right != null) {
//    		root.left.next = root.right;
//    		if(root.next != null) {
//    			if(root.next.left != null) {
//    				root.right.next = root.next.left;
//    			}else if(root.next.right != null) {
//    				root.right.next = root.next.right;
//    			}else {
//    				root.right.next = null;
//    			}
//    		}else {
//    			root.right.next = null;
//    		}
//    	}else if(root.left != null) {
//    		if(root.next == null) {
//    			root.left.next = null;
//    		}else if(root.next.left != null) {
//    			root.left.next = root.next.left;
//    		}else if(root.next.right != null) {
//    			root.left.next = root.next.right;
//    		}else root.left.next = null;
//    	}else {
//    		if(root.next == null) {
//    			root.right.next = null;
//    		}else if(root.next.left != null) {
//    			root.right.next = root.next.left;
//    		}else if(root.next.right != null) {
//    			root.right.next = root.next.right;
//    		}else root.right.next = null;
//    	}
//    	helper(root.left);
//    	helper(root.right);
    }
    
	public static void main(String[] args) {
		P117 p = new P117();
//		p.connect(new TreeLinkNode(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,null,null,8}, 0));
		p.connect(new TreeLinkNode(new Integer[]{2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7}, 0));
	}

}
