package cn.zayn.design.mode.ddd;

import java.math.BigDecimal;

public class VirtualWalletDDD {
    public class VirtualWallet { // Domain 领域模型 (充血模型)
        private Long id;
        private Long createTime = System.currentTimeMillis();;
        private BigDecimal balance = BigDecimal.ZERO;

        public VirtualWallet(Long preAllocatedId) {
            this.id = preAllocatedId;
        }

        public BigDecimal balance() {
            return this.balance;
        }

        public void debit(BigDecimal amount) {
            if (this.balance.compareTo(amount) < 0) {
             //   throw new InsufficientBalanceException(...);
            }
            this.balance.subtract(amount);
        }

        public void credit(BigDecimal amount) {
            if (amount.compareTo(BigDecimal.ZERO) < 0) {
               // throw new InvalidAmountException(...);
            }
            this.balance.add(amount);
        }
    }
    public class VirtualWalletService {
        // 通过构造函数或者 IOC 框架注入
        private VirtualWalletRepository walletRepo;
        private VirtualWalletTransactionRepository transactionRepo;
        private VirtualWalletService virtualWalletRepo;

        public VirtualWallet getVirtualWallet(Long walletId) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            VirtualWallet wallet = convert(walletEntity);
            return wallet;
        }

        private VirtualWallet convert(VirtualWalletEntity walletEntity) {
            return null;
        }

        public BigDecimal getBalance(Long walletId) {
            return virtualWalletRepo.getBalance(walletId);
        }

        public void debit(Long walletId, BigDecimal amount) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            VirtualWallet wallet = convert(walletEntity);
            wallet.debit(amount);
            walletRepo.updateBalance(walletId, wallet.balance());
        }

        public void credit(Long walletId, BigDecimal amount) {
            VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
            VirtualWallet wallet = convert(walletEntity);
            wallet.credit(amount);
            walletRepo.updateBalance(walletId, wallet.balance());
        }

        public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
            //... 跟基于贫血模型的传统开发模式的代码一样...
        }
    }

    private class VirtualWalletRepository {
        public VirtualWalletEntity getWalletEntity(Long walletId) {
            return null;
        }

        public void updateBalance(Long walletId, BigDecimal balance) {
        }
    }

    private class VirtualWalletTransactionRepository {
    }

    private class VirtualWalletEntity {
    }
}
