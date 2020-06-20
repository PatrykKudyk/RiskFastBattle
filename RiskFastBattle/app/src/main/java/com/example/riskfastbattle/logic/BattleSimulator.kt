package com.example.riskfastbattle.logic

import androidx.recyclerview.widget.BatchingListUpdateCallback
import com.example.riskfastbattle.models.Battle
import kotlin.random.Random

class BattleSimulator() {

    fun makeBattle(attacker: Int, defender: Int): ArrayList<Battle> {
        var list = ArrayList<Battle>()
        var attack = attacker
        var defend = defender
        list.add(Battle(attack, defend))
        do {
            var battle: Battle
            if (attack >= 3 && defend >= 2) {
                battle = compute3vs2(attack, defend)
            } else if (attack >= 3 && defend == 1) {
                battle = compute3vs1(attack, defend)
            } else if (attack == 2 && defend >= 2) {
                battle = compute2vs2(attack, defend)
            } else if (attack == 2 && defend == 1) {
                battle = compute2vs1()
            } else if (attack == 1 && defend >= 2) {
                battle = compute1vs2(defend)
            } else {
                battle = compute1vs1()
            }
            list.add(battle)
            attack = battle.attacker
            defend = battle.defender
        } while (!isEnd(attack, defend))

        return list
    }

    private fun compute3vs2(attacker: Int, defender: Int): Battle {
        var attackerFinal = attacker
        var defenderFinal = defender
        val defend1 = Random.nextInt(1, 7)
        val defend2 = Random.nextInt(1, 7)
        val attack1 = Random.nextInt(1, 7)
        val attack2 = Random.nextInt(1, 7)
        val attack3 = Random.nextInt(1, 7)

        if (attack1 >= attack2 && attack1 >= attack3) {
            if (defend1 > defend2) {
                if (defend1 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (attack2 >= attack3) {
                    if (defend2 >= attack2) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend2 >= attack3) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            } else {
                if (defend2 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (attack2 >= attack3) {
                    if (defend1 >= attack2) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend1 >= attack3) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            }
        } else if (attack2 >= attack1 && attack2 >= attack3) {
            if (defend1 > defend2) {
                if (defend1 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (attack1 >= attack3) {
                    if (defend2 >= attack1) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend2 >= attack3) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            } else {
                if (defend2 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }

                if (attack1 >= attack3) {
                    if (defend1 >= attack1) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend1 >= attack3) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            }
        } else if (attack3 >= attack1 && attack3 >= attack2) {
            if (defend1 > defend2) {
                if (defend1 >= attack3) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }

                if (attack1 >= attack2) {
                    if (defend2 >= attack1) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend2 >= attack2) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            } else {
                if (defend2 >= attack3) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (attack1 >= attack2) {
                    if (defend1 >= attack1) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                } else {
                    if (defend1 >= attack2) {
                        attackerFinal--
                    } else {
                        defenderFinal--
                    }
                }
            }
        }
        return Battle(attackerFinal, defenderFinal)
    }

    private fun compute3vs1(attacker: Int, defender: Int): Battle {
        val defend = Random.nextInt(1, 7)
        val attack1 = Random.nextInt(1, 7)
        val attack2 = Random.nextInt(1, 7)
        val attack3 = Random.nextInt(1, 7)
        if (attack1 >= attack2 && attack1 >= attack3) {
            if (defend >= attack1) {
                return Battle(attacker - 1, defender)
            } else {
                return Battle(attacker, 0)
            }
        } else if (attack2 >= attack1 && attack2 >= attack3) {
            if (defend >= attack2) {
                return Battle(attacker - 1, defender)
            } else {
                return Battle(attacker, 0)
            }
        } else {
            if (defend >= attack3) {
                return Battle(attacker - 1, defender)
            } else {
                return Battle(attacker, 0)
            }
        }
    }


    private fun compute2vs2(attacker: Int, defender: Int): Battle {
        var attackerFinal = attacker
        var defenderFinal = defender
        val defend1 = Random.nextInt(1, 7)
        val defend2 = Random.nextInt(1, 7)
        val attack1 = Random.nextInt(1, 7)
        val attack2 = Random.nextInt(1, 7)
        if (defend1 >= defend2) {
            if (attack1 >= attack2) {
                if (defend1 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (defend2 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
            } else {
                if (defend1 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (defend2 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
            }

        } else {
            if (attack2 >= attack2) {
                if (defend2 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (defend1 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
            } else {
                if (defend2 >= attack2) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
                if (defend1 >= attack1) {
                    attackerFinal--
                } else {
                    defenderFinal--
                }
            }
        }

        return Battle(attackerFinal, defenderFinal)
    }


    private fun compute2vs1(): Battle {
        val defend = Random.nextInt(1, 7)
        val attack1 = Random.nextInt(1, 7)
        val attack2 = Random.nextInt(1, 7)
        if (attack1 > defend || attack2 > defend) {
            return Battle(2, 0)
        } else {
            return Battle(1, 1)
        }
    }


    private fun compute1vs2(defender: Int): Battle {
        val defend1 = Random.nextInt(1, 7)
        val defend2 = Random.nextInt(1, 7)
        val attack = Random.nextInt(1, 7)
        if (defend1 >= attack || defend2 >= attack) {
            return Battle(0, defender)
        } else {
            return Battle(1, defender - 1)
        }
    }


    private fun compute1vs1(): Battle {
        val attack = Random.nextInt(1, 7)
        val defend = Random.nextInt(1, 7)
        if (defend >= attack) {
            return Battle(0, 1)
        } else {
            return Battle(1, 0)
        }
    }

    private fun isEnd(attacker: Int, defender: Int): Boolean {
        if (attacker == 0) {
            return true
        } else if (defender == 0) {
            return true
        }
        return false
    }
}