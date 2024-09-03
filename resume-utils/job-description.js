import { badWords } from "./data/bad-words.js";
import { mySkills } from "./data/resume-skills.js";
import { jobSkills } from "./data/job-skills.js";

export const validateJobDescription = (jd = "") => {
  jd = jd.toLowerCase();

  jd = jd.replace(/[^a-z0-9\s.+]/g, "");
  const arrOfWords = jd.split(/\s+/);

  if (arrOfWords.length < 30) {
    return { isValidJd: false, message: "Job description is too short." };
  }

  let isValidJd = true;

  const lowerCaseJd = jd.toLowerCase();

  let badWordsString = "";

  badWords.forEach((word) => {
    const regex = new RegExp(`\\b${word}\\b`, "gi"); // Word boundary and case-insensitive
    if (regex.test(lowerCaseJd)) {
      isValidJd = false;
      badWordsString += word + " ";
    }
  });

  if (!isValidJd) {
    return {
      isValidJd,
      message: `Job description contains inappropriate language: ${badWordsString}`,
    };
  }

  let uniqueWords = new Set(arrOfWords);

  return {
    isValidJd,
    uniqueWords: Array.from(uniqueWords),
    message: "Job description is valid.",
  };
};

export const analyzeJobDecription = (words) => {
  try {
    const foundSkills = new Set(
      words.filter((word) => {
        return jobSkills.includes(word);
      })
    );

    const arrOfFoundSkills = Array.from(foundSkills);

    if (arrOfFoundSkills.length === 0) throw new Error("No job skills found!");

    const matchedSkills = arrOfFoundSkills.filter((skill) => mySkills.includes(skill));

    if (matchedSkills.length === 0) throw new Error("No matched skills found");

    return { jobSkills: arrOfFoundSkills, matchedSkills };
  } catch (e) {
    return { error: e.message };
  }
};
