package ua.lviv.iot.career;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CareerTest {
    
    int[][] careerPathOnFirstJob = {{4}, {3, 1}, {2, 1, 5}, {1, 3, 2, 1}};
    int[][] careerPathOnSecondJob = {{0}, {1, 1}, {0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 1, 0}};
    int[][] careerPathOnThirdJob = {{0}, {5, 8}, {6, 1, 1}, {1, 8, 10, 3}, {1, 6, 2, 10, 0}, {9, 4, 7, 3, 3, 0}};
    int[][] careerPathOnFourthJob = {{9999}};
    
    int quantityOfLevelsOnFirstJob = careerPathOnFirstJob.length;
    int quantityOfLevelsOnSecondJob = careerPathOnSecondJob.length;
    int quantityOfLevelsOnThirdJob = careerPathOnThirdJob.length;
    int quantityOfLevelsOnFourthJob = careerPathOnFourthJob.length;


    @Test
    public void testFirstWork() {
        int expectedMaxSumOfExperienceOnFirstJob = 12;
        
        CareerPath careerOnFirstJob = new CareerPath(quantityOfLevelsOnFirstJob, careerPathOnFirstJob);
        int maxSumOfExperienceOnFirstJob = CareerPathManager.countMaxSumOfExperience(careerOnFirstJob);
        
        assertEquals(expectedMaxSumOfExperienceOnFirstJob, maxSumOfExperienceOnFirstJob);
        
    }
    
    @Test
    public void testSecondWork() {
        int expectedMaxSumOfExperienceOnSecondJob = 3;
        
        CareerPath careerOnSecondJob = new CareerPath(quantityOfLevelsOnSecondJob, careerPathOnSecondJob);
        int maxSumOfExperienceOnSecondJob = CareerPathManager.countMaxSumOfExperience(careerOnSecondJob);
        
        assertEquals(expectedMaxSumOfExperienceOnSecondJob, maxSumOfExperienceOnSecondJob);
    }
    
    @Test
    public void testThirdWork() {
        int expectedMaxSumOfExperienceOnThirdJob = 32;
        
        CareerPath careerOnThirdJob = new CareerPath(quantityOfLevelsOnThirdJob, careerPathOnThirdJob);
        int maxSumOfExperienceOnThirdJob = CareerPathManager.countMaxSumOfExperience(careerOnThirdJob);
        
        assertEquals(expectedMaxSumOfExperienceOnThirdJob, maxSumOfExperienceOnThirdJob);
    }
    
    @Test
    public void testForthWork() {
        int expectedMaxSumOfExperienceOnForthJob = 9999;
        
        CareerPath careerOnForthJob = new CareerPath(quantityOfLevelsOnFourthJob, careerPathOnFourthJob);
        int maxSumOfExperienceOnForthJob = CareerPathManager.countMaxSumOfExperience(careerOnForthJob);
        
        assertEquals(expectedMaxSumOfExperienceOnForthJob, maxSumOfExperienceOnForthJob);
        
    }
}
