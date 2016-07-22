package main
 
import (
	"fmt"
)
 
func main() {
	var s string
	var i int
	fmt.Scan(&s, &i)
	fmt.Println(string([]rune(s)[i - 1]))
}
