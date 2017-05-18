grammar BasicListPattern;

packageSegmentList
  : Identifier
  | packageSegmentList DOT Identifier
  ;
   
DOT: '.';
Identifier: [A-Za-z]+; 
