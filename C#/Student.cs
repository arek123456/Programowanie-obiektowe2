using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programowanie_obiektowe_2.Lab02
{
    internal class Student : Person
    {
        protected string school;
        protected bool mayReturnOnHisOwn;
        public string School { get; set; }
        public bool MayReturnOnHisOwn { get; set; }

        public void SetSchool(string school)
        {
            school = school;
        }

        public void ChangeSchool(string newSchool)
        {
            school = newSchool;
        }

        public void SetCanGoHomeAlone(bool canGoHome)
        {
            mayReturnOnHisOwn = canGoHome;
        }

        public override string GetEducationInfo()
        {
            return $"Uczeń, Szkoła: {school}";
        }

        public override bool CanGoAloneToHome()
        {
            if (GetAge() < 12 && !mayReturnOnHisOwn)
            {
                Console.WriteLine("Uczeń poniżej 12 lat nie może wracać sam do domu bez pozwolenia.");
                return false;
            }

            return true;
        }
    }
}
