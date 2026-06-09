// package JUNE_8;

// import java.util.ArrayList;
// import java.util.List;



// class Solution {
//     public void solve(int n,int op,int cl,String ans,List<String> res)
//     {
//         if(op==n && cl==n)
//         {
//           res.add(ans); 
//           return ;
//         }
//         else 
//         {
//           if(op<n)
//           {
//             solve(n,op+1,cl,ans+"(",res);
//           }
//           if(op>cl)
//           {
//             solve(n,op,cl+1,ans+")",res);
//           }
//         }
//     }
//     public List<String> generateParenthesis(int n)
//     {
//         List<String> res = new ArrayList<>(); 
//         int op=0,cl=0; 
//         String ans=""; 
//         solve(n,op,cl,ans,res); 
//         return res;
//     }
// }


// class jun_8 { 

//     public List<int[]> merge(List<int[]> left,List<int[]> right) 
//     {
//         List<int[]> res = new ArrayList<>();
//          int i=0,j=0; 
//          int h1=0,h2=0; 
//          int x=0; 
//          while(i<left.size() && j<right.size())
//          {
//            if(left.get(i)[0] < right.get(j)[0])
//            {
//              x = left.get(i)[0]; 
//              h1 = left.get(i)[1]; 
//              i++; 
//            }
//            else if(left.get(i)[0] > right.get(j)[0])
//            {
//              x = right.get(j)[0]; 
//              h2 = right.get(j)[1];
//              j++; 
//            }
//            else 
//            {
//              x = right.get(j)[0];
//              h1 = left.get(i)[1];
//              h2 = right.get(j)[1];
//              i++;
//              j++;
//            }
//            int m = Math.max(h1,h2); 
//            if(res.isEmpty() || res.get(res.size()-1)[1]!=m)
//            {
//             res.add(new int[]{x,m});
//            }
//          }
//          while(i<left.size())
//          {
//            x = left.get(i)[0]; 
//              h1 = left.get(i)[1]; 
//              i++; 
//              int m = Math.max(h1,h2); 
//            if(res.isEmpty() || res.get(res.size()-1)[1]!=m)
//            {
//             res.add(new int[]{x,m});
//            }
//          }
//          while(j<right.size())
//          {
//            x = right.get(j)[0]; 
//              h2 = right.get(j)[1]; 
//              j++; 
//              int m = Math.max(h1,h2); 
//            if(res.isEmpty() || res.get(res.size()-1)[1]!=m)
//            {
//             res.add(new int[]{x,m});
//            }
//          }
//          return res;
//     }
//     public List<int[]> build(int[][] buildings,int start,int end)
//     {//start = 0  end = 5
//         if(start>=end)
//         {
//             return new ArrayList<>();
//         }
//         if(start+1 == end)
//         {
//           List<int[]> res = new ArrayList<>();  
//           res.add(new int[]{buildings[start][0],buildings[start][2]});
//           res.add(new int[]{buildings[start][1],0});
//           return res;

//         }
//         int mid = (start+end)/2; //mid=2 ; 
//         List<int[]> left = build(buildings,start,mid);
//         List<int[]> right = build(buildings,mid,end);  
//         return merge(left,right);


//     }
//     public List<List<Integer>> getSkyline(int[][] buildings) 
//     {
//         int n = buildings.length; 
//         if(n==0)
//         {
//             return new ArrayList<>();
//         } 
//        List<int[]> pairs =  build(buildings,0,n);
//        List<List<Integer>> ans = new ArrayList<>();
//        for(int[] p : pairs)
//        {
//         ans.add(Arrays.asList(p[0],p[1])); 
//        }
//        return  ans;
//     }
// }


// class Solution˙ {
//     public void solve(String digits,List<String> res,String[] map,String ans,int i)
//     { // digits="23"  res = [] , ans = "" , i = 0
//         if(i==digits.length())
//         {
//             res.add(ans); 
//             return;
//         }
//         else 
//         {
//             String temp = map[digits.charAt(i)-'0']; //temp = abc; 
//             for(int j=0; j<temp.length();j++)
//             {
//                 solve(digits,res,map,ans+temp.charAt(j),i+1);
//             }
//         }
//     }
//     public List<String> letterCombinations(String digits)
//     {//digits = "23" 
//       List<String> res = new ArrayList<>(); 
//       if(digits.length()==0)
//       {
//         return res;
//       }
//       String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//       solve(digits,res,map,"",0);//functionn calling   
//       return res;
//     }
// }