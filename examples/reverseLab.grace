fun main () : nothing
  var r : char[32];

  fun reverse (ref s : char[]) : nothing
    var i, l : int;
  {
    l <- strlen(s);
    i <- 0;
    while i < l do {
      r[i] <- s[l-i-1];
      i <- i+1;
    }
    r[i] <- '\0';
  }

{
  reverse("\n!dlrow olleH");
  puts(r);
}
