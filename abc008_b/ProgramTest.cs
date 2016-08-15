using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;

namespace AtCoder
{
    [TestClass]
    public class ProgramTest
    {
        [TestMethod]
        public void 入力例1()
        {
            string input =
@"4
taro
jiro
taro
saburo";
            string output =
@"taro";

            AssertIO(input, output);
        }

        [TestMethod]
        public void 入力例2()
        {
            string input =
@"1
takahashikun";
            string output =
@"takahashikun";

            AssertIO(input, output);
        }

        [TestMethod]
        public void 入力例3()
        {
            string input =
@"9
a
b
c
c
b
c
b
d
e";
            string output =
@"b";

            AssertIO(input, output);
        }

        private void AssertIO(string input, string output)
        {
            StringReader reader = new StringReader(input);
            Console.SetIn(reader);

            StringWriter writer = new StringWriter();
            Console.SetOut(writer);

            Program.Main(new string[0]);

            Assert.AreEqual(output + Environment.NewLine, writer.ToString());
        }
    }
}
