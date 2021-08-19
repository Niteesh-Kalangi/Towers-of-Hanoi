
	import java.util.ArrayList;
	import java.util.Collections;

	public class Towers {
		private ArrayList<Integer> left;
		private ArrayList<Integer> middle;
		private ArrayList<Integer> right;

		public Towers(ArrayList<Integer> left, ArrayList<Integer> middle, ArrayList<Integer> right) {
			super();
			this.left = left;
			this.middle = middle;
			this.right = right;


		}
		public Towers() {
			super();
			this.left= new ArrayList<Integer>(3);
			this.left.add(3); this.left.add(2); this.left.add(1);
			this.middle=new ArrayList<Integer>(0);
			this.right=new ArrayList<Integer>(0);

		}

		public ArrayList<Integer> getLeft() {
			return left;
		}
		public void setLeft(ArrayList<Integer> left) {
			this.left = left;
		}
		public ArrayList<Integer> getMiddle() {
			return middle;
		}
		public void setMiddle(ArrayList<Integer> middle) {
			this.middle = middle;
		}
		public ArrayList<Integer> getRight() {
			return right;
		}
		public void setRight(ArrayList<Integer> right) {
			this.right = right;
		}
		public String toString() {
			String toString="";
			int x=Math.max(Math.max(left.size(), right.size()), middle.size());

			for(int i=0; i<x; i++) {
				if(left.size()>i)
					toString+=left.get(i)+" ";
				else
					toString+="  ";
				if(middle.size()>i)
					toString+=middle.get(i)+" ";
				else
					toString+="  ";
				if(right.size()>i)
					toString+=right.get(i)+" ";
				
				toString+='\n';

		}
			return toString;

	}
		public int getCount() {
			int x=0;
			if(left!=null)
				x+=left.size();
			if(right!=null)
				x+=right.size();
			if(middle!=null)
				x+=middle.size();
			
			return x;
		}
		public void reset() {
			if(middle!=null) {
				for(Integer e: middle)
					left.add(e);
			}
				if(right!=null) {
					for(Integer e: right)
						left.add(e);
				
			}
				Collections.sort(left);
				Collections.reverse(left);;
				right.clear();
				middle.clear();
			
		
		}
		public void setTower(int rings) {
	
			left.clear();
			middle.clear();
			right.clear();
			for(int i=rings; i>0; i--) {
				left.add(i);
			}
			
		}
		public boolean isSolved() {
			if(left.size()==0&&middle.size()==0)
				return true;
			return false;
		}
		private boolean isLegal(ArrayList<Integer> a, ArrayList<Integer> b) {
			if(b!=a&&a!=null&&a.size()!=0&&(b.size()==0||a.get(a.size()-1)<b.get(b.size()-1)))
				return true;
			return false;
		}
		public boolean makeMove(int one, int two, boolean eitherOne) {
			ArrayList<Integer> x= new ArrayList<Integer>();
			ArrayList<Integer> y= new ArrayList<Integer>();
			int z = 0;
			if(one==0)
				x=left;
			else if(one==1)
				x=middle;
			else if(one==2)
				x=right;
			
			if(two==0)
				y=left;
			else if(two==1)
				y=middle;
			else if(two==2)
				y=right;
				
			if(one<0||one>2||two<0||two>2)
				return false;
			
			if(eitherOne==false) {
				if(isLegal(x, y)) {
					z=x.get(x.size()-1);
					x.remove(x.size()-1);
					y.add(z);
					return true;
				}
				
					
			}
			else {
				if(isLegal(x, y)) {
				z=x.get(x.size()-1);
				x.remove(x.size()-1);
				y.add(z);
				return true;
				}
				else if(isLegal(y, x)) {
				z=y.get(y.size()-1);
				y.remove(y.size()-1);
				x.add(z);
				return true;
				}
			}
			return false;
				
					
				
			
		}

	}