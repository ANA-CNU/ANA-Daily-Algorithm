import axios from "axios";

import {
  filterBlackList,
  getMonthlyCommits,
  getSolveCountByUser,
  getPrizeRank,
  getRecentSolved,
} from "./anabada.js";

const sendPrizeRank = async () => {
  const monthlyCommits = filterBlackList(await getMonthlyCommits());
  const solveCountByUser = getSolveCountByUser(monthlyCommits);
  const prizeRank = getPrizeRank(solveCountByUser);
  const recentSolved = getRecentSolved(monthlyCommits);

  let result = `\`${recentSolved[0].userName}\` 님이 새로운 문제를 해결해서 추첨 결과가 바뀌었습니다.\n`;
  result += `https://ana-cnu.github.io/bada/ 에서 확인하세요!\n\n`;

  for (let i = 0; i < prizeRank.length; i++) {
    result += `${i + 1}. \`${prizeRank[i]}\`: ${
      solveCountByUser[prizeRank[i]]
    } 문제\n`;
  }

  const data = {
    username: "anabada",
    avatar_url: "https://ana-cnu.github.io/img/logo.png",
    content: result,
  };

  await axios.post(process.env.DISCORD_WEBHOOK_URL, data);
};

sendPrizeRank();
